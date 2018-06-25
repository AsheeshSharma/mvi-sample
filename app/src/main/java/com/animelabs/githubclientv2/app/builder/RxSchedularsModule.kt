package com.animelabs.githubclientv2.app.builder

import com.animelabs.githubclientv2.utilities.rx.RxSchedulars
import com.animelabs.githubclientv2.utilities.rx.SchedularImpl
import dagger.Module
import dagger.Provides

@Module
class RxSchedularsModule {
    @AppScope
    @Provides
    fun getRxSchedulars() : RxSchedulars {
        return SchedularImpl()
    }
}