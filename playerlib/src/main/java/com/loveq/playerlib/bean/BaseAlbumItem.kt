package com.loveq.playerlib.bean

/**
 * Created by Rc on 2020/3/16
 * 音乐的合集
 */
class BaseAlbumItem<T, S> {

    var albumTitle: String? = null

    var musicList: ArrayList<BaseMusicItem>? = null

    var albumId: String? = null

    var extraData: S? = null




}