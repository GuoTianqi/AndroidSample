package com.daybreak.androidsample.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.NotificationCompat
import android.support.v4.app.NotificationManagerCompat
import android.support.v4.app.TaskStackBuilder
import android.util.Log
import com.daybreak.androidsample.BaseToolBarActivity
import com.daybreak.androidsample.R
import com.daybreak.androidsample.databinding.NotificationActivityBinding
import android.os.Build

class NotificationActivity: BaseToolBarActivity() {
    lateinit var viewModel: NotificationViewModel
    lateinit var binding: NotificationActivityBinding
    var numMessages = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentLayout(R.layout.notification_activity)

        viewModel = ViewModelProviders.of(this).get(NotificationViewModel::class.java)

        binding = NotificationActivityBinding.bind(contentLayout)
        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel


        createNotificationChannel()

        viewModel.showNotify.observe(this, Observer {
            Log.d("XXX", "show Notification")

            val builder = NotificationCompat.Builder(this@NotificationActivity, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_event_available_black_24dp)
                .setContentTitle("My notification")
                .setContentText("Hello World!")
                .setNumber(++numMessages)

            val inboxStyle = NotificationCompat.InboxStyle().also {
                it.setBigContentTitle("Event tracker details:")
            }

            val events = Array(6) { i -> "Event $i"}

            for (event in events) {
                inboxStyle.addLine(event)
            }

            builder.setStyle(inboxStyle)

            val resultIntent = Intent(this@NotificationActivity, NotificationActivity::class.java)
            val stackBuilder = TaskStackBuilder.create(this@NotificationActivity)
            stackBuilder.addParentStack(NotificationActivity::class.java)
            stackBuilder.addNextIntent(resultIntent)
            val resultPeddingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
            builder.setContentIntent(resultPeddingIntent)

            NotificationManagerCompat.from(this@NotificationActivity).notify(0xff01, builder.build())

        })
    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "测试"
            val description = "测试通知"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager!!.createNotificationChannel(channel)
        }
    }

    companion object {
        const val CHANNEL_ID = "test"
    }
}