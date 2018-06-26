package com.animelabs.githubclientv2.activities.userListModule.mvi

sealed class UserListActivityActions {
    object LoadDataFromServer : UserListActivityActions()
}