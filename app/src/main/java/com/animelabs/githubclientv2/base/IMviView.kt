package com.animelabs.githubclientv2.base

import rx.Observable


interface IMviView<I : BaseMviIntent, in S: BaseMviViewState> {
    fun render(state : S)
    fun intents() : Observable<I>
}