package com.daybreak.androidsample.notification

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.core.app.NotificationCompat
import android.util.Log
import com.daybreak.androidsample.archlifecycle.SingleLiveEvent

class NotificationViewModel(application: Application): AndroidViewModel(application) {
    val showNotify = SingleLiveEvent<Void>()

    fun showNotification() {
        Log.d("XXX", "show Notification")
        showNotify.call()
    }
}