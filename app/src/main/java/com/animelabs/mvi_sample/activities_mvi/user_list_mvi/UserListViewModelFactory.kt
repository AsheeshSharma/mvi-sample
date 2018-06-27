package com.animelabs.mvi_sample.activities_mvi.user_list_mvi

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import javax.inject.Inject

class UserListViewModelFactory @Inject constructor(val actionProcessor: UserListActionProcessor) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserListViewModel(actionProcessor) as T
    }

}