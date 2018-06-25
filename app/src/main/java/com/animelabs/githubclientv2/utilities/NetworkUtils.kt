package com.animelabs.githubclientv2.utilities

import android.content.Context
import android.net.ConnectivityManager

class NetworkUtils {
    companion object {
        fun inNetworkAvailable(context: Context): Boolean {
            val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            return activeNetworkInfo != null && activeNetworkInfo.isConnected
        }
    }

}