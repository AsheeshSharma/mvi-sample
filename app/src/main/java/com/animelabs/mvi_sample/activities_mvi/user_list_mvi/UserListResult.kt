package com.animelabs.mvi_sample.activities_mvi.user_list_mvi

import com.animelabs.mvi_sample.data.models.UserResponse

sealed class UserListResult {
    sealed class UserListSearchResult : UserListResult() {
        data class Success(val variations: List<UserResponse>) : UserListSearchResult()
        data class Failure(val error: Throwable) : UserListSearchResult()
        object InFlight : UserListSearchResult()

    }
}