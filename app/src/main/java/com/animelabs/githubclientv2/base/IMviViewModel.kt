package com.animelabs.githubclientv2.base

import rx.Observable

interface IMviViewModel<I: BaseMviIntent, S: BaseMviViewState> {
    fun processIntents(intents : Observable<I>)
    fun states(): Observable<S>
}