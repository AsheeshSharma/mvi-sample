package com.animelabs.mvi_sample.dagger.components

import com.animelabs.mvi_sample.app.App
import com.animelabs.mvi_sample.dagger.modules.ActivityBindingModule
import com.animelabs.mvi_sample.dagger.modules.AppModule
import com.animelabs.mvi_sample.dagger.modules.DataModule
import com.animelabs.mvi_sample.dagger.modules.NetworkModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class,
        AppModule::class, DataModule::class, NetworkModule::class,
        ActivityBindingModule::class))
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract fun appModule(appModule: AppModule) : Builder
        override fun seedInstance(instance: App?) {
            appModule(AppModule(instance!!))
        }
    }
}