package com.animelabs.mvi_sample.activities_mvi.user_list_mvi

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.animelabs.mvi_sample.base.mvibase.MviViewModel
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.BiFunction
import io.reactivex.subjects.PublishSubject

class UserListViewModel constructor(private val actionProcessor: UserListActionProcessor) : ViewModel(), MviViewModel<UserListIntent, UserListViewState> {

    private val intentSubject: PublishSubject<UserListIntent> = PublishSubject.create()
    private val statesObservable: Observable<UserListViewState> = compose()
    private val statesLiveData: MutableLiveData<UserListViewState> = MutableLiveData()
    private val disposables: CompositeDisposable = CompositeDisposable()

    init {
        disposables.add(statesObservable.subscribe { statesLiveData.value = it })
    }

    fun compose(): Observable<UserListViewState> {
        return intentSubject
                .map { this::actionFromIntent }
                .compose(actionProcessor.transfromFromAction())
                .scan(UserListViewState.idle(), reducer)
                .distinctUntilChanged()
                .replay(1)
                .autoConnect(0)
    }

    companion object {
        private val reducer = BiFunction { previousState: UserListViewState, result: UserListResult ->
            when (result) {
                is UserListResult.UserListSearchResult -> when (result) {
                    is UserListResult.UserListSearchResult.Success -> {
                        previousState.copy(
                                isLoading = false,
                                users = result.variations
                        )
                    }
                    is UserListResult.UserListSearchResult.Failure -> {
                        previousState.copy()
                    }

                    is UserListResult.UserListSearchResult.InFlight ->
                        previousState.copy(isLoading = true)

                }

            }
        }
    }

    //TODO : To support multiple just use UserListAction
    private fun actionFromIntent(intent: UserListIntent): UserListAction {
        return when (intent) {
            is UserListIntent.SearchListIntent -> UserListAction.LoadUsersAction(intent.searchText)
            else -> throw IllegalArgumentException("unknown intent")
        }
    }

    override fun processIntents(intents: Observable<UserListIntent>) {
        intents.subscribe(intentSubject)
    }

    override fun states(): LiveData<UserListViewState> {
        return statesLiveData
    }
}