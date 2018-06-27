package com.animelabs.mvi_sample.data

import com.animelabs.mvi_sample.data.models.UserItemModel
import com.animelabs.mvi_sample.data.remote.GithubAPIService
import io.reactivex.Observable
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(val githubAPIService: GithubAPIService): GithubRepository {
    override fun loadPizza(): Observable<UserItemModel> {
        return githubAPIService.getUsersLists()
    }
}