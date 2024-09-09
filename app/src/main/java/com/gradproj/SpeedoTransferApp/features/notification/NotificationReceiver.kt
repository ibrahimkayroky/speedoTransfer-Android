package com.gradproj.SpeedoTransferApp.features.notification

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

class NotificationReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        sendNotification(intent.getStringExtra("title")!!, intent.getStringExtra("text")!!,intent.getIntExtra("icon",0),context)
    }
}
