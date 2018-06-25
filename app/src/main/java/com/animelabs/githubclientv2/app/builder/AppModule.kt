package com.animelabs.githubclientv2.app.builder

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(val appModuleContext: Context) {

    @AppScope
    @Provides
    fun getApplicationContext() : Context {
        return appModuleContext
    }

}