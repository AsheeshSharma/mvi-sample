package com.animelabs.githubclientv2.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.animelabs.githubclientv2.utilities.NetworkUtils
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_base.*

abstract class BaseActivity : AppCompatActivity() {

    val disposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        init(savedInstanceState)
    }

    abstract fun getLayoutId() : Int
    abstract fun init(savedInstance: Bundle?)

    fun showProgress() {
        if (progressBar != null) {
            progressBar.visibility = View.VISIBLE
        }
    }

    fun hideProgress() {
        if (progressBar != null && progressBar.isShown) {
            progressBar.visibility = View.GONE
        }
    }

    fun shouldShowNoInternetText() {
        if (noInternetTextView != null && !NetworkUtils.inNetworkAvailable(this)) {
            noInternetTextView.visibility = View.VISIBLE
        } else {
            noInternetTextView.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}