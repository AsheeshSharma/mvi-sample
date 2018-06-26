package com.animelabs.githubclientv2.activities.userListModule.mvi

import com.animelabs.githubclientv2.base.BaseMviViewState
import com.animelabs.githubclientv2.models.ResponseModel

data class UserListActivityViewState(var loading:Boolean,
                                 var eventsResponse: ResponseModel?): BaseMviViewState