package com.animelabs.mvi_sample.activities_mvi.user_list_mvi

import com.animelabs.mvi_sample.base.mvibase.MviViewState
import com.animelabs.mvi_sample.data.models.UserResponse

data class UserListViewState (
        val isLoading: Boolean,
        val users: List<UserResponse>,
        val error: Throwable?) : MviViewState {
    companion object {
        fun idle(): UserListViewState {
            return UserListViewState(
                    isLoading = false,
                    users = emptyList(),
                    error = null
            )
        }
    }
}