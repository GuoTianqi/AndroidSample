package com.daybreak.androidsample.notification

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel
import android.support.v4.app.NotificationCompat
import android.util.Log
import com.daybreak.androidsample.archlifecycle.SingleLiveEvent

class NotificationViewModel(application: Application): AndroidViewModel(application) {
    val showNotify = SingleLiveEvent<Void>()

    fun showNotification() {
        Log.d("XXX", "show Notification")
        showNotify.call()
    }
}