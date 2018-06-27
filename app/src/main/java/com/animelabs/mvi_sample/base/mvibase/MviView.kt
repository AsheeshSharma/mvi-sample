package com.animelabs.mvi_sample.base.mvibase

import io.reactivex.Observable

interface MviView<I: MviIntent, S : MviViewState> {
    fun render(state : S)
    fun intents() : Observable<I>
}