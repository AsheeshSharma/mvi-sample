package com.animelabs.mvi_sample.dagger.modules

import android.app.Application
import android.content.Context
import com.animelabs.mvi_sample.app.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val application: Application) {
    @Singleton
    @Provides
    fun provideAppContext() : Context = application
}