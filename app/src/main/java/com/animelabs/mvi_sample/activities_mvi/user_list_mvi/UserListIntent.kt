package com.animelabs.mvi_sample.activities_mvi.user_list_mvi

import com.animelabs.mvi_sample.base.mvibase.MviIntent

sealed class UserListIntent : MviIntent {
    data class SearchListIntent(val searchText: String) : UserListIntent()
}