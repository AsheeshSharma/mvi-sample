package com.animelabs.githubclientv2.api

import com.animelabs.githubclientv2.models.ResponseModel
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface GithubApiService {
    @GET("search/users")
    fun getUsers(@Query("sort") sort: String, @Query("q") query: String): Observable<ResponseModel>
}