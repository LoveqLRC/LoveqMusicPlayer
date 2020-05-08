package com.loveq.playerlib.helper

import android.media.AudioAttributes.CONTENT_TYPE_MUSIC
import android.media.MediaPlayer
import android.media.MediaPlayer.OnCompletionListener
import com.loveq.playerlib.utils.VideoCache

/**
 * Created by Rc on 2020/3/16
 */
class MediaPlayerHelper private constructor() : OnCompletionListener, MediaPlayer.OnErrorListener,
    MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnSeekCompleteListener,
    MediaPlayer.OnVideoSizeChangedListener, MediaPlayer.OnBufferingUpdateListener {


    var player: MediaPlayer = MediaPlayer().apply {
        setOnCompletionListener(this@MediaPlayerHelper)
        setOnErrorListener(this@MediaPlayerHelper)
        setOnInfoListener(this@MediaPlayerHelper)
        setOnPreparedListener(this@MediaPlayerHelper)
        setOnSeekCompleteListener(this@MediaPlayerHelper)
        setOnVideoSizeChangedListener(this@MediaPlayerHelper)
        setOnBufferingUpdateListener(this@MediaPlayerHelper)
    }


    fun play(url: String) {
        player.reset()
        player.setDataSource(VideoCache.getInstance().getProxyUrl(url))
        player.prepare()
    }

    override fun onCompletion(mp: MediaPlayer?) {
    }

    override fun onError(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        return false
    }

    override fun onInfo(mp: MediaPlayer?, what: Int, extra: Int): Boolean {
        return false
    }

    override fun onPrepared(mp: MediaPlayer?) {
        player.start()
    }

    override fun onSeekComplete(mp: MediaPlayer?) {
    }

    override fun onVideoSizeChanged(mp: MediaPlayer?, width: Int, height: Int) {

    }

    override fun onBufferingUpdate(mp: MediaPlayer?, percent: Int) {

    }


    companion object {

        @Volatile
        private var instance: MediaPlayerHelper? = null


        fun getInstance() = instance ?: synchronized(this) {
            instance ?: MediaPlayerHelper().also {
                instance = it
            }
        }

    }

}