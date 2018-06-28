package com.animelabs.mvi_sample.data.remote

import com.animelabs.mvi_sample.data.models.UserItemModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubAPI {
    companion object {
        val BASE_URL = "https://api.github.com/"
    }
    @GET("search/users")
    fun getUsersList(@Query("sort") sort : String, @Query("q") query : String) : Observable<UserItemModel>
}