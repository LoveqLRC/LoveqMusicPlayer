package com.loveq.loveqmusicplayer.musicservice

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Build.VERSION.SDK_INT
import android.os.IBinder
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.loveq.loveqmusicplayer.MainActivity
import com.loveq.loveqmusicplayer.R
import com.loveq.playerlib.bean.BaseMusicItem

/**
 * Created by Rc on 2020/5/8
 */
class MusicService : Service() {

    val GROUP_ID = "GROUP_ID"
    val CHANNEL_ID = "CHANNEL_ID"

    override fun onBind(intent: Intent?): IBinder? {

        return null
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

//        createNotification()
        return super.onStartCommand(intent, flags, startId)
    }


    private fun createNotification(baseMusicItem: BaseMusicItem<*>) {
        val title = baseMusicItem.musicTitle
        val albumTitle = baseMusicItem.albumTitle

        val simpleContentView = RemoteViews(
            application.packageName,
            R.layout.notify_player_small
        )
        val expandedView = RemoteViews(
            application.packageName,
            R.layout.notify_player_big
        )

        val intent = Intent(applicationContext, MainActivity::class.java)

        val contentIntent = PendingIntent.getActivity(this, 0, intent, 0)

        if (SDK_INT >= Build.VERSION_CODES.O) {
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

            val playGroup = NotificationChannelGroup(GROUP_ID, "播放")

            notificationManager.createNotificationChannelGroup(playGroup)

            val playChannel = NotificationChannel(
                CHANNEL_ID,
                "播放时的通知栏",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            playChannel.group = GROUP_ID

            notificationManager.createNotificationChannel(playChannel)
        }

        val notification = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_player)
            .setContentIntent(contentIntent)
            .setOnlyAlertOnce(true)
            .setContentTitle(title)
            .build()

        notification.contentView = simpleContentView
        notification.bigContentView = expandedView


        setListeners(simpleContentView)
        setListeners(expandedView)


    }

    private fun setListeners(simpleContentView: RemoteViews) {


    }


}