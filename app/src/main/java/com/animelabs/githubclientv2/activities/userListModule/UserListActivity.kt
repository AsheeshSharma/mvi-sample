package com.animelabs.githubclientv2.activities.userListModule

import android.os.Bundle
import com.animelabs.githubclientv2.R
import com.animelabs.githubclientv2.activities.userListModule.mvi.UserListActivityIntent
import com.animelabs.githubclientv2.activities.userListModule.mvi.UserListActivityViewState
import com.animelabs.githubclientv2.base.BaseActivity
import com.animelabs.githubclientv2.base.IMviView
import io.reactivex.Observable
import timber.log.Timber

class UserListActivity : BaseActivity(), IMviView<UserListActivityIntent, UserListActivityViewState> {
    override fun render(state: UserListActivityViewState) {
        val statesValue = state
        Timber.log(1,"Inside")
    }

    override fun onStart() {
        super.onStart()
        val viewModelClass = UserListActivityModelClass()
        disposable.add(viewModelClass.states().subscribe({ render(it) },{ it.printStackTrace() }))
        viewModelClass.processIntents(intents())
    }

    override fun intents(): Observable<UserListActivityIntent> {
        return Observable.just(UserListActivityIntent.OnClickSeachButton)
    }

    override fun getLayoutId(): Int {
        return R.layout.activity_users_list
    }

    override fun init(savedInstance: Bundle?) {
       Timber.log(1, "Init Called, List Activity")
    }
}