package com.animelabs.mvi_sample.dagger.modules

import com.animelabs.mvi_sample.data.GithubRepository
import com.animelabs.mvi_sample.data.GithubRepositoryImpl
import com.animelabs.mvi_sample.data.remote.GithubAPIService
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideGithubRepository(service: GithubAPIService): GithubRepository {
        return GithubRepositoryImpl(service)
    }
}