package com.animelabs.mvi_sample.activities_mvi.user_list_mvi

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import com.animelabs.mvi_sample.R
import com.animelabs.mvi_sample.adapters.RecyclerViewAdapter
import com.animelabs.mvi_sample.base.BaseActivity
import com.animelabs.mvi_sample.base.mvibase.MviView
import com.animelabs.mvi_sample.data.models.UserResponse
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.reactivex.subjects.PublishSubject
import timber.log.Timber
import javax.inject.Inject
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_users_list.*


class UserListActivity : BaseActivity(), MviView<UserListIntent.SearchListIntent, UserListViewState>{

    @Inject
    lateinit var factory: UserListViewModelFactory

    lateinit var adapter: RecyclerViewAdapter

    private val selectGroupVariationsIntent = PublishSubject.create<UserListIntent.SearchListIntent>()

    override fun render(state: UserListViewState) {
        with(state) {
            when(isLoading) {
                true -> showProgress()
                false -> hideProgress()
            }
            if(!users.isEmpty()){
                Timber.log(1, users.toString() + "")
                adapter.setData(users as ArrayList<UserResponse>)
            }
        }
    }

    override fun intents(): Observable<UserListIntent.SearchListIntent> {
        return  selectGroupVariationsIntent
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return injector
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_users_list
    }

    override fun init(savedInstance: Bundle?) {
        Timber.log(1, "Init Called")
        bind()
        bindUIAndInitialise()
    }

    private fun bindUIAndInitialise() {
        /*editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                selectGroupVariationsIntent.onNext(UserListIntent.SearchListIntent(p0.toString()))
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

        })*/
        activity_heroes_list_recycleview.layoutManager = LinearLayoutManager(this@UserListActivity)
        adapter = RecyclerViewAdapter(ArrayList<UserResponse>(), this@UserListActivity)
        activity_heroes_list_recycleview.adapter = adapter
        button.setOnClickListener {
            adapter.clearAdapter()
            selectGroupVariationsIntent.onNext(UserListIntent.SearchListIntent(editText.text.toString()))
        }
        selectGroupVariationsIntent.onNext(UserListIntent.SearchListIntent("Asheesh"))
    }

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    private val viewModel: UserListViewModel by lazy(LazyThreadSafetyMode.NONE) {
        ViewModelProviders.of(this, factory).get(UserListViewModel::class.java)
    }


    private fun bind() {
        viewModel.processIntents(intents())
        viewModel.states().observe(this, Observer {
            if (it != null) {
                render(it)
            }
        })
    }
}