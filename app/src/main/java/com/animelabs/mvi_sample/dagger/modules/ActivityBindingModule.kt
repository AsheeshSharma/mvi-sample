package com.animelabs.mvi_sample.dagger.modules

import com.animelabs.mvi_sample.activities_mvi.user_list_mvi.UserListActivity
import com.animelabs.mvi_sample.dagger.modules.userListingModule.UserListingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector(modules = [UserListingModule::class])
    abstract fun getActivityContext() : UserListActivity
}