package com.animelabs.mvi_sample.activities_mvi.user_list_mvi

import com.animelabs.mvi_sample.data.GithubRepository
import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class UserListActionProcessor @Inject constructor(val repository: GithubRepository) {
    // TODO : Change in case of multiple actions, use Observable.merge
    fun transfromFromAction(): ObservableTransformer<UserListAction, UserListResult.UserListSearchResult> {
        return ObservableTransformer { action ->
            action.publish { shared ->
                        shared.ofType(UserListAction.LoadUsersAction::class.java).compose(loadUsers())
            }
        }
    }

    fun loadUsers(): ObservableTransformer<UserListAction.LoadUsersAction, UserListResult.UserListSearchResult> {
        return ObservableTransformer { action ->
            action.flatMap {
                repository.loadUsers(it.searchText)
                        .map { selectableItems -> UserListResult.UserListSearchResult.Success(selectableItems.users) }
                        .cast(UserListResult.UserListSearchResult::class.java)
                        .onErrorReturn { t -> UserListResult.UserListSearchResult.Failure(t) }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .startWith(UserListResult.UserListSearchResult.InFlight)
            }
        }
    }

    fun loadUsersMock(): ObservableTransformer<UserListAction.LoadUsersAction, UserListResult.UserListSearchResult> {
        return ObservableTransformer { action ->
            action.flatMap {
                repository.loadUsers(it.searchText)
                        .map { selectableItems -> UserListResult.UserListSearchResult.Success(selectableItems.users) }
                        .cast(UserListResult.UserListSearchResult::class.java)
                        .onErrorReturn { t -> UserListResult.UserListSearchResult.Failure(t) }
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .startWith(UserListResult.UserListSearchResult.InFlight)
            }
        }
    }
}