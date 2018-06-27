package com.animelabs.mvi_sample.dagger.modules.userListingModule

import com.animelabs.mvi_sample.activities_mvi.user_list_mvi.UserListActionProcessor
import com.animelabs.mvi_sample.activities_mvi.user_list_mvi.UserListViewModelFactory
import com.animelabs.mvi_sample.dagger.modules.DataModule
import com.animelabs.mvi_sample.dagger.scope.AppScope
import dagger.Module
import dagger.Provides

@Module(includes = [DataModule::class])
class UserListingModule {
    @Provides
    @AppScope
    fun getViewModelFactoryInstance(actionProcessor: UserListActionProcessor) : UserListViewModelFactory {
        return UserListViewModelFactory(actionProcessor)
    }
}