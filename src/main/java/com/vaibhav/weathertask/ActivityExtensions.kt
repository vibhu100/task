package com.vaibhav.weathertask

import android.app.Activity
import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

fun Activity.isNetworkAvailable(): Boolean {

    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    if (cm.activeNetworkInfo != null) {
        if(!cm.activeNetworkInfo!!.isConnected)
        {
            toast("Internet Connection Required")
            return false
        }
        else
            return cm!!.activeNetworkInfo!!.isConnected
    }
    return false
}

fun Activity.toast(msg : String)
{
    Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
}