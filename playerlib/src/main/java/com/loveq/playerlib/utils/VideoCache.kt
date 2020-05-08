package com.loveq.playerlib.utils

import com.danikula.videocache.HttpProxyCacheServer
import com.danikula.videocache.file.FileNameGenerator

/**
 * Created by Rc on 2020/3/19
 */
class VideoCache {
    private var proxy: HttpProxyCacheServer

    init {
        proxy = newProxy()
    }


    private fun newProxy() = HttpProxyCacheServer.Builder(AppGlobals.getApplication())
        .fileNameGenerator(VideoFileNameGenerator())
        .build()


    fun getProxyUrl(url: String): String = proxy.getProxyUrl(url)

    companion object {

        @Volatile
        private var instance: VideoCache? = null

        fun getInstance() = instance ?: synchronized(this) {
            instance ?: VideoCache().also {
                instance = it
            }
        }
    }


    inner class VideoFileNameGenerator : FileNameGenerator {
        override fun generate(url: String?): String {
            val split = url!!.split("/").toTypedArray()
            return split[split.size - 1]
        }
    }

}