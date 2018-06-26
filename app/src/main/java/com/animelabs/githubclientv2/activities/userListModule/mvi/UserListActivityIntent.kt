package com.animelabs.githubclientv2.activities.userListModule.mvi

import com.animelabs.githubclientv2.base.BaseMviIntent

sealed class UserListActivityIntent : BaseMviIntent {
    object OnClickSeachButton: UserListActivityIntent()
    object OnTypeChangeSearch: UserListActivityIntent()
}