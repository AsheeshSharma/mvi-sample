package com.animelabs.githubclientv2.app.builder

import android.content.Context
import com.animelabs.githubclientv2.utilities.rx.SchedularImpl
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File

@Module
class NetworkModule {
    @AppScope
    @Provides
    fun provideHttpClient(logger: HttpLoggingInterceptor, cache: Cache): OkHttpClient {
        val builder = OkHttpClient().newBuilder()
        builder.addInterceptor(logger)
        builder.cache(cache)
        return builder.build()
    }

    @AppScope
    @Provides
    fun provideInterceptor(): HttpLoggingInterceptor {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return httpLoggingInterceptor
    }

    @AppScope
    @Provides
    fun provideCache(file: File): Cache {
        return Cache(file, (10 * 10 * 1000).toLong())
    }

    @AppScope
    @Provides
    fun provideCacheFile(context: Context): File {
        return context.filesDir
    }

    @AppScope
    @Provides
    fun provideRxAdapter(): RxJavaCallAdapterFactory {
        return RxJavaCallAdapterFactory.createWithScheduler(SchedularImpl().INTERNET_SCHEDULERS)
    }

    @AppScope
    @Provides
    fun provideGsonClient(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }
}