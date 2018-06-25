package com.animelabs.githubclientv2.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.animelabs.githubclientv2.R
import com.animelabs.githubclientv2.base.BaseActivity
import timber.log.Timber

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_users_list
    }

    override fun init(savedInstance: Bundle?) {
        Timber.log(1 ,"Called init")
    }
}
