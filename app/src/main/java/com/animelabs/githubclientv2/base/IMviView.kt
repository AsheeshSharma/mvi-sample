package com.animelabs.githubclientv2.base

import io.reactivex.Observable


interface IMviView<I : BaseMviIntent, in S: BaseMviViewState> {
    fun render(state : S)
    fun intents() : Observable<I>
}