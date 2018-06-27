package com.animelabs.mvi_sample.app

import android.app.Application
import com.animelabs.mvi_sample.dagger.components.DaggerAppComponent
import com.animelabs.mvi_sample.dagger.modules.AppModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val component = DaggerAppComponent.builder().appModule(AppModule(this)).build()
        return component!!
    }
}