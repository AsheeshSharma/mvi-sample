package com.animelabs.githubclientv2.activities.userListModule

import android.util.Log
import com.animelabs.githubclientv2.activities.userListModule.mvi.UserListActivityActions
import com.animelabs.githubclientv2.activities.userListModule.mvi.UserListActivityIntent
import com.animelabs.githubclientv2.activities.userListModule.mvi.UserListActivityResult
import com.animelabs.githubclientv2.activities.userListModule.mvi.UserListActivityViewState
import com.animelabs.githubclientv2.base.IMviViewModel
import com.animelabs.githubclientv2.models.ResponseModel
import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject

class UserListActivityModelClass : IMviViewModel<UserListActivityIntent, UserListActivityViewState> {

    private val intentSubject: PublishSubject<UserListActivityIntent> = PublishSubject.create()

    override fun processIntents(intents: Observable<UserListActivityIntent>) {
        intents.subscribe(intentSubject)
    }

    override fun states(): Observable<UserListActivityViewState> {
        return intentSubject
                .map({ intentToActions(it) })
                .compose(actionProcessor())
                .scan(UserListActivityViewState(true, null), resultToState)
                .distinctUntilChanged()
    }

    private fun actionProcessor() = ObservableTransformer<UserListActivityActions, UserListActivityResult> { actions ->
        actions.publish { observableActions ->
            observableActions.ofType(UserListActivityActions.LoadDataFromServer::class.java).flatMap({ getMockedResult() })
        }
    }

    private val resultToState = BiFunction { previousState:UserListActivityViewState, result:UserListActivityResult ->
        when(result){
            is UserListActivityResult.FetchEventsResult.Success -> {
                previousState.copy(loading = false,eventsResponse = result.eventsResponse)
            }
            is UserListActivityResult.FetchEventsResult.Failure -> {
                previousState.copy(loading = false, eventsResponse = null)
            }
            is UserListActivityResult.FetchEventsResult.Loading -> {
                previousState.copy(loading = true,eventsResponse = null )
            }
        }
    }

    private fun getMockedResult(): ObservableSource<out UserListActivityResult>? {
        return null
    }

    private fun intentToActions(intents: UserListActivityIntent): UserListActivityActions {
        return when (intents) {
            is UserListActivityIntent.OnClickSeachButton -> {
                UserListActivityActions.LoadDataFromServer
            }
            is UserListActivityIntent.OnTypeChangeSearch -> {
                UserListActivityActions.LoadDataFromServer
            }
        }
    }
}