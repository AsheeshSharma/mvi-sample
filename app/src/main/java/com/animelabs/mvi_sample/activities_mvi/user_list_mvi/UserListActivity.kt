package com.animelabs.mvi_sample.activities_mvi.user_list_mvi

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.widget.Toast
import com.animelabs.mvi_sample.R
import com.animelabs.mvi_sample.base.BaseActivity
import com.animelabs.mvi_sample.base.mvibase.MviView
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import io.reactivex.subjects.PublishSubject
import timber.log.Timber
import javax.inject.Inject
import io.reactivex.Observable


class UserListActivity : BaseActivity(), MviView<UserListIntent.SearchListIntent, UserListViewState>{

    @Inject
    lateinit var factory: UserListViewModelFactory

    private val selectGroupVariationsIntent = PublishSubject.create<UserListIntent.SearchListIntent>()

    override fun render(state: UserListViewState) {
        with(state) {
            when(isLoading) {
                true -> Toast.makeText(this@UserListActivity, "Loading",Toast.LENGTH_SHORT).show()
                false -> Toast.makeText(this@UserListActivity, "Done",Toast.LENGTH_SHORT).show()
            }
            if(!users.isEmpty()){
                Timber.log(1, users.toString() + "")
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