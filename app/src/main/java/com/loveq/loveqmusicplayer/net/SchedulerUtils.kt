package com.loveq.loveqmusicplayer.net

import com.loveq.loveqmusicplayer.net.IoMainCompose

object SchedulerUtils {
    fun <T> ioToMain(): IoMainCompose<T> {
        return IoMainCompose()
    }
}