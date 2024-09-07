package com.gradproj.SpeedoTransferApp.features.notification

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Build
import android.provider.Settings.Global.getString
import androidx.core.app.NotificationCompat

import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat.getSystemService
import com.gradproj.SpeedoTransferApp.MainActivity
import com.gradproj.SpeedoTransferApp.R

fun sendNotification(title: String, text: String,icon:Int, context: Context) {
    createNotificationChannel(context)
    // Create an intent that will open your app when notification is clicked
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("myapp://details"))
    val pendingIntent: PendingIntent = PendingIntent.getActivity(
        context, 0, intent, PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    )
    val builder = Notification.Builder(context, "1")
        .setContentTitle(title)
        .setContentText(text)
        .setAutoCancel(true)
        .setSmallIcon(icon)
        .setShowWhen(true)
        .setWhen(System.currentTimeMillis())

        .setLargeIcon(BitmapFactory.decodeResource(context.resources, R.drawable.ic_right_red)) // Replace with your image resource
        .setContentIntent(pendingIntent)
        .setAutoCancel(true)
    NotificationManagerCompat.from(context).notify(1, builder.build())
}
private fun createNotificationChannel(context: Context,) {
    // Create the NotificationChannel, but only on API 26+ because
    // the NotificationChannel class is not in the Support Library.
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        val name = "Complete Transaction"
        val descriptionText = "Complete Transaction notification"
        val importance = NotificationManager.IMPORTANCE_HIGH
        val channel = NotificationChannel("1", name, importance).apply {
            description = descriptionText
        }
        // Register the channel with the system.
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }
}
