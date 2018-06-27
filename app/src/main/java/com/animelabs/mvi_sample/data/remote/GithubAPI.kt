package com.animelabs.mvi_sample.data.remote

import com.animelabs.mvi_sample.data.models.UserItemModel
import io.reactivex.Observable
import retrofit2.http.GET

interface GithubAPI {
    companion object {
        val BASE_URL = ""
    }
    @GET("")
    fun getUsersList() : Observable<UserItemModel>
}