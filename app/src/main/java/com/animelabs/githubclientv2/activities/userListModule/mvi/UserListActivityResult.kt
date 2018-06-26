package com.animelabs.githubclientv2.activities.userListModule.mvi

import com.animelabs.githubclientv2.models.ResponseModel

sealed class UserListActivityResult {

    sealed class FetchEventsResult {
        data class Success(val eventsResponse:ResponseModel): UserListActivityResult()
        data class Failure(val error:String): UserListActivityResult()
        object Loading: UserListActivityResult()
    }

}