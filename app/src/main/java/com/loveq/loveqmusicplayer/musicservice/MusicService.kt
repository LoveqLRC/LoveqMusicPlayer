package com.loveq.loveqmusicplayer.musicservice

import android.app.Notification
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.loveq.loveqmusicplayer.MainActivity
import com.loveq.loveqmusicplayer.R
import com.loveq.loveqmusicplayer.notification.GlobalNotificationBuilder
import com.loveq.loveqmusicplayer.notification.NotificationUtils
import com.loveq.loveqmusicplayer.utils.CHANNEL_ID
import com.loveq.playerlib.bean.BaseMusicItem

/**
 * Created by Rc on 2020/5/8
 */
class MusicService : Service() {

    override fun onBind(intent: Intent?): IBinder? {

        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        createNotification(BaseMusicItem("地址", "标题", "album标题"))
        return super.onStartCommand(intent, flags, startId)
    }


    private fun createNotification(baseMusicItem: BaseMusicItem) {
        val title = baseMusicItem.musicTitle

        NotificationUtils.createNotificationChannel()


        val intent = Intent(this, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val notifyPendingIntent =
            PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)

        val notificationCompatBuilder = NotificationCompat.Builder(
            applicationContext, CHANNEL_ID
        )
        GlobalNotificationBuilder.setNotificationCompatBuilderInstance(notificationCompatBuilder)


        val contentView = RemoteViews(
            application.packageName,
            R.layout.notify_player_small
        )


        val bigContentView = RemoteViews(
            application.packageName,
            R.layout.notify_player_big
        )


        val notification =
            notificationCompatBuilder
                .setCustomContentView(contentView)
                .setCustomBigContentView(bigContentView)
                .setContentIntent(notifyPendingIntent)
                .setContentTitle(title)
                .setSmallIcon(R.drawable.ic_player)
                .build()


        NotificationManagerCompat.from(applicationContext).notify(88, notification)


    }

    private fun setListeners(simpleContentView: RemoteViews) {


    }


}