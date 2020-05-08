package com.loveq.playerlib.helper

import android.text.TextUtils
import com.loveq.playerlib.bean.BaseAlbumItem
import com.loveq.playerlib.bean.BaseMusicItem
import java.util.HashMap

/**
 * Created by Rc on 2020/3/19
 */
class MediaController private constructor() {
    private val albums = HashMap<String, BaseAlbumItem<*, *>>()

    var currentPlayingAlbumId: String? = null


    fun setMusicAlbum(albumsId: String, album: BaseAlbumItem<*, *>) {
        currentPlayingAlbumId = albumsId
        albums[albumsId] = album
    }


    fun playMusicItemByAlbumPosition(position: Int) {
        val musicItem = getMusicItemByAlbumPosition(position)
        if (musicItem != null) {
            MediaPlayerHelper.getInstance().play(musicItem.musicUrl)
        }
    }

    private fun getMusicItemByAlbumPosition(position: Int): BaseMusicItem<*>? {
        if (TextUtils.isEmpty(currentPlayingAlbumId)) {
            return null
        }
        val baseAlbumItem = albums[currentPlayingAlbumId]!!
        val musicList = baseAlbumItem.musicList ?: return null

        if (position < 0 || position > musicList.size - 1) {
            return null
        }
        return musicList[position]
    }


    companion object {

        @Volatile
        private var instance: MediaController? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MediaController().also {
                instance = it
            }
        }

    }
}