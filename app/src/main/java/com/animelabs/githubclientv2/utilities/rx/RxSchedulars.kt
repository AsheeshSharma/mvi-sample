package com.animelabs.githubclientv2.utilities.rx

import rx.Scheduler

interface RxSchedulars {
    fun runInBackground() : Scheduler
    fun runOnIo() : Scheduler
    fun runOnAndroidThread() : Scheduler
    fun runOnCompute() : Scheduler
    fun runOnInternet() : Scheduler
}