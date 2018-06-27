package com.animelabs.mvi_sample.base.mvibase

import android.arch.lifecycle.LiveData
import io.reactivex.Observable

interface MviViewModel<I: MviIntent, S: MviViewState> {
    fun processIntents(intents : Observable<I>)
    fun states() : LiveData<S>
}