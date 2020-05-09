package com.loveq.loveqmusicplayer.notification;

import androidx.core.app.NotificationCompat;

/**
 * Created by Rc on 2020/5/9
 */
public class GlobalNotificationBuilder {
    private static NotificationCompat.Builder sGlobalNotificationCompatBuilder = null;


    private GlobalNotificationBuilder() {
    }

    public static void setNotificationCompatBuilderInstance(NotificationCompat.Builder builder) {
        sGlobalNotificationCompatBuilder = builder;
    }

    public static NotificationCompat.Builder getNotificationCompatBuilderInstance() {
        return sGlobalNotificationCompatBuilder;
    }
}
