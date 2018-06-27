package com.animelabs.mvi_sample.data.remote

class GithubAPIService(val githubAPI: GithubAPI) {
    fun getUsersLists() = githubAPI.getUsersList()
}