package com.animelabs.githubclientv2.app.builder

import com.animelabs.githubclientv2.api.GithubApiService
import com.animelabs.githubclientv2.utilities.rx.RxSchedulars
import dagger.Component

@Component(modules = arrayOf(AppModule::class, NetworkModule::class, RxSchedularsModule::class, GithubAPIServiceModule::class))
interface AppComponent {
    fun getSchedulars() : RxSchedulars
    fun getGithubApiService() : GithubApiService
}