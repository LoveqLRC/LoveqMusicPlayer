package com.loveq.playerlib.bean

/**
 * Created by Rc on 2020/3/16
 */
open class BaseMusicItem<T>(
    var musicUrl: String,
    var musicTitle: String,
    var albumTitle: String,
    var extraData: T? = null
)