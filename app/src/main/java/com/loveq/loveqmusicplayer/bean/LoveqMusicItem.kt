package com.loveq.loveqmusicplayer.bean

import com.loveq.playerlib.bean.BaseMusicItem

/**
 * Created by Rc on 2020/5/14
 */
class LoveqMusicItem(musicUrl: String, musicName: String) : BaseMusicItem(musicUrl, musicName) {
    lateinit var albumId: String
    lateinit var subAlbumId: String
    var downloadCount: Int = 0


}