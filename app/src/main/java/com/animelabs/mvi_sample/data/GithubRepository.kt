package com.animelabs.mvi_sample.data

import com.animelabs.mvi_sample.data.models.UserItemModel
import io.reactivex.Observable

interface GithubRepository {
    fun loadPizza() : Observable<UserItemModel>
}