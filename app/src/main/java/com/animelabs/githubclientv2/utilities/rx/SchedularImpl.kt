package com.animelabs.githubclientv2.utilities.rx

import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import java.util.concurrent.Executor
import java.util.concurrent.Executors

class SchedularImpl : RxSchedulars {

    var backgroundExecutor: Executor = Executors.newCachedThreadPool()
    var BACKGROUND_SCHEDULERS = Schedulers.from(backgroundExecutor)
    var internetExecutor: Executor = Executors.newCachedThreadPool()
    val INTERNET_SCHEDULERS = Schedulers.from(internetExecutor)

    override fun runInBackground(): Scheduler {
        return BACKGROUND_SCHEDULERS
    }

    override fun runOnIo(): Scheduler {
        return BACKGROUND_SCHEDULERS
    }

    override fun runOnAndroidThread(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    override fun runOnCompute(): Scheduler {
        return Schedulers.io()
    }

    override fun runOnInternet(): Scheduler {
        return INTERNET_SCHEDULERS
    }
}