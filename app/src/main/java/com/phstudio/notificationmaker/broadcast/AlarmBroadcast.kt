package com.phstudio.notificationmaker.broadcast

import android.annotation.SuppressLint
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Build
import android.os.Environment
import androidx.core.app.NotificationCompat
import com.phstudio.notificationmaker.MainActivity
import com.phstudio.notificationmaker.R
import java.io.File

class AlarmBroadcast : BroadcastReceiver() {

    @SuppressLint("UnspecifiedImmutableFlag")
    override fun onReceive(context: Context, intent: Intent) {
        val bundle = intent.extras
        val text = bundle!!.getString("title")
        val label = bundle.getString("label")
        val small_icon = bundle.getInt("small_icon")
        val big_icon = bundle.getInt("big_icon")
        val notify_id = bundle.getInt("notificationId")
        val remove = bundle.getBoolean("remove")
        val colored = bundle.getBoolean("colored")
        val color = bundle.getInt("color")
        val typenotify = bundle.getString("style")
        val imageUri: Bitmap?

        val prefs = context.getSharedPreferences(
            context.resources.getString(R.string.app_package),
            Context.MODE_PRIVATE
        ).edit()
        prefs.putString("send", "Yes").apply()

        if (typenotify == "bigtext") {
            if (colored) {
                val intent1 = Intent(context, MainActivity::class.java)
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                val pendingIntent = PendingIntent.getActivity(
                    context,
                    1,
                    intent1,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
                val notificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val mBuilder = NotificationCompat.Builder(context, "notify_001")
                mBuilder.setContentTitle(text)
                mBuilder.setContentText(label)
                mBuilder.setTicker(label)
                mBuilder.setLargeIcon(BitmapFactory.decodeResource(context.resources, (big_icon)))
                mBuilder.setSmallIcon(small_icon)
                mBuilder.setAutoCancel(true)
                mBuilder.setOngoing(remove)
                mBuilder.setOnlyAlertOnce(true)
                mBuilder.setStyle(NotificationCompat.BigTextStyle().bigText(label))
                mBuilder.color = (color)
                mBuilder.setColorized(true)
                mBuilder.priority = Notification.PRIORITY_HIGH
                mBuilder.build().flags = Notification.FLAG_NO_CLEAR or Notification.PRIORITY_HIGH
                mBuilder.setContentIntent(pendingIntent)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val channel = NotificationChannel(
                        "notification",
                        "Default",
                        NotificationManager.IMPORTANCE_HIGH
                    )
                    channel.enableVibration(true)
                    notificationManager.createNotificationChannel(channel)
                    mBuilder.setChannelId("notification")
                }
                val notification = mBuilder.build()
                notificationManager.notify(notify_id, notification)
            } else if (!colored) {
                val intent1 = Intent(context, MainActivity::class.java)
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                val pendingIntent =
                    PendingIntent.getActivity(
                        context,
                        1,
                        intent1,
                        PendingIntent.FLAG_UPDATE_CURRENT
                    )
                val notificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val mBuilder = NotificationCompat.Builder(context, "notify_001")
                mBuilder.setContentTitle(text)
                mBuilder.setContentText(label)
                mBuilder.setTicker(label)
                mBuilder.setLargeIcon(BitmapFactory.decodeResource(context.resources, (big_icon)))
                mBuilder.setSmallIcon(small_icon)
                mBuilder.setStyle(NotificationCompat.BigTextStyle().bigText(label))
                mBuilder.setAutoCancel(true)
                mBuilder.setOngoing(remove)
                mBuilder.setOnlyAlertOnce(true)
                mBuilder.priority = Notification.PRIORITY_HIGH
                mBuilder.build().flags = Notification.FLAG_NO_CLEAR or Notification.PRIORITY_HIGH
                mBuilder.setContentIntent(pendingIntent)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val channel = NotificationChannel(
                        "notification",
                        "Default",
                        NotificationManager.IMPORTANCE_HIGH
                    )
                    channel.enableVibration(true)
                    notificationManager.createNotificationChannel(channel)
                    mBuilder.setChannelId("notification")
                }
                val notification = mBuilder.build()
                notificationManager.notify(notify_id, notification)
            }
        } else if (typenotify == "picture") {
            val sharedPreferences = context.getSharedPreferences(
                context.resources.getString(R.string.app_package),
                Context.MODE_PRIVATE
            )
            val picname = sharedPreferences.getString("nextpicture", "")!!

            val filename = File(
                Environment.getExternalStorageDirectory().toString(),
                context.getString(R.string.app_name) + "/${picname}.jpg"
            )
            imageUri = if (filename.exists()) {
                val filename2 = (File(
                    Environment.getExternalStorageDirectory().toString(),
                    context.getString(R.string.app_name) + "/${picname}.jpg"
                )).toString()
                BitmapFactory.decodeFile(filename2)
            } else {
                val pic001 = BitmapFactory.decodeResource(context.resources, (R.drawable.pic001))
                pic001
            }
            if (colored) {
                val intent1 = Intent(context, MainActivity::class.java)
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                val pendingIntent = PendingIntent.getActivity(
                    context,
                    1,
                    intent1,
                    PendingIntent.FLAG_UPDATE_CURRENT
                )
                val notificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val mBuilder = NotificationCompat.Builder(context, "notify_001")
                mBuilder.setContentTitle(text)
                mBuilder.setContentText(label)
                mBuilder.setTicker(label)
                mBuilder.setLargeIcon(BitmapFactory.decodeResource(context.resources, (big_icon)))
                mBuilder.setSmallIcon(small_icon)
                mBuilder.setAutoCancel(true)
                mBuilder.setOngoing(remove)
                mBuilder.setOnlyAlertOnce(true)
                mBuilder.setStyle(NotificationCompat.BigPictureStyle().bigPicture((imageUri)))
                mBuilder.color = (color)
                mBuilder.setColorized(true)
                mBuilder.priority = Notification.PRIORITY_HIGH
                mBuilder.build().flags = Notification.FLAG_NO_CLEAR or Notification.PRIORITY_HIGH
                mBuilder.setContentIntent(pendingIntent)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val channel = NotificationChannel(
                        "notification",
                        "Default",
                        NotificationManager.IMPORTANCE_HIGH
                    )
                    channel.enableVibration(true)
                    notificationManager.createNotificationChannel(channel)
                    mBuilder.setChannelId("notification")
                }
                val notification = mBuilder.build()
                notificationManager.notify(notify_id, notification)
            } else if (!colored) {
                val intent1 = Intent(context, MainActivity::class.java)
                intent1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                val pendingIntent =
                    PendingIntent.getActivity(
                        context,
                        1,
                        intent1,
                        PendingIntent.FLAG_UPDATE_CURRENT
                    )
                val notificationManager =
                    context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
                val mBuilder = NotificationCompat.Builder(context, "notify_001")
                mBuilder.setContentTitle(text)
                mBuilder.setContentText(label)
                mBuilder.setTicker(label)
                mBuilder.setLargeIcon(BitmapFactory.decodeResource(context.resources, (big_icon)))
                mBuilder.setSmallIcon(small_icon)
                mBuilder.setStyle(NotificationCompat.BigPictureStyle().bigPicture((imageUri)))
                mBuilder.setAutoCancel(true)
                mBuilder.setOngoing(remove)
                mBuilder.setOnlyAlertOnce(true)
                mBuilder.priority = Notification.PRIORITY_HIGH
                mBuilder.build().flags = Notification.FLAG_NO_CLEAR or Notification.PRIORITY_HIGH
                mBuilder.setContentIntent(pendingIntent)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    val channel = NotificationChannel(
                        "notification",
                        "Default",
                        NotificationManager.IMPORTANCE_HIGH
                    )
                    channel.enableVibration(true)
                    notificationManager.createNotificationChannel(channel)
                    mBuilder.setChannelId("notification")
                }
                val notification = mBuilder.build()
                notificationManager.notify(notify_id, notification)
            }
            if (filename.exists()) {
                filename.delete()
            }
        }
    }
}