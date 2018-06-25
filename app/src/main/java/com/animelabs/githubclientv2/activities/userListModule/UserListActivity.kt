package com.animelabs.githubclientv2.activities.userListModule

import android.os.Bundle
import com.animelabs.githubclientv2.R
import com.animelabs.githubclientv2.base.BaseActivity
import timber.log.Timber

class UserListActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_users_list
    }

    override fun init(savedInstance: Bundle?) {
       Timber.log(1, "Init Called, List Activity")
    }
}