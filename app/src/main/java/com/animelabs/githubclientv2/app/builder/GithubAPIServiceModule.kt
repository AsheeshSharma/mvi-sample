package com.animelabs.githubclientv2.app.builder

import com.animelabs.githubclientv2.api.GithubApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class GithubAPIServiceModule {

    val BASE_URL = "https://api.github.com/"

    @AppScope
    @Provides
    fun getGithubAPIService(okHttpClient: OkHttpClient, gsonConverterFactory: GsonConverterFactory, rxJavaCallAdapterFactory: RxJavaCallAdapterFactory) : GithubApiService {
        val retrofit = Retrofit.Builder().client(okHttpClient)
                .baseUrl(BASE_URL).addConverterFactory(gsonConverterFactory).addCallAdapterFactory(rxJavaCallAdapterFactory).build()
        return retrofit.create(GithubApiService::class.java)

    }
}