package com.loveq.loveqmusicplayer.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import com.loveq.loveqmusicplayer.utils.CHANNEL_DESCRIPTION
import com.loveq.loveqmusicplayer.utils.CHANNEL_ID
import com.loveq.loveqmusicplayer.utils.CHANNEL_NAME
import com.loveq.playerlib.utils.AppGlobals

/**
 * Created by Rc on 2020/5/9
 */
object NotificationUtils {

    fun createNotificationChannel(): String? {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channelId = CHANNEL_ID
            val channelName = CHANNEL_NAME
            val channelDescription = CHANNEL_DESCRIPTION

            val channelImportance = NotificationManager.IMPORTANCE_DEFAULT

            val channelEnableVibrate = false

            val channelLockscreenVisibility = NotificationCompat.VISIBILITY_PUBLIC


            val notificationChannel = NotificationChannel(channelId, channelName, channelImportance)
                .apply {
                    description = channelDescription
                    enableVibration(false)
                    lockscreenVisibility = channelLockscreenVisibility
                }


            val notificationManager = AppGlobals.getApplication()
                .getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager


            notificationManager.createNotificationChannel(notificationChannel)


            return channelId

        } else {
            return null
        }
    }
}