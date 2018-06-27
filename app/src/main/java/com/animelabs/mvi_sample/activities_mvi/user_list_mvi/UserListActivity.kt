package com.animelabs.mvi_sample.activities_mvi.user_list_mvi

import android.os.Bundle
import com.animelabs.mvi_sample.R
import com.animelabs.mvi_sample.base.BaseActivity
import timber.log.Timber

class UserListActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_users_list
    }

    override fun init(savedInstance: Bundle?) {
        Timber.log(1, "Init Called")
    }
}