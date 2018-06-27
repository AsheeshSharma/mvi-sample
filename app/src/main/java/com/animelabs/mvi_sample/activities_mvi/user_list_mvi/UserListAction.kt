package com.animelabs.mvi_sample.activities_mvi.user_list_mvi

import com.animelabs.mvi_sample.base.mvibase.MviAction

sealed class UserListAction : MviAction {
    data class LoadUsersAction(val searchText : String) : UserListAction()
}