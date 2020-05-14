package com.loveq.loveqmusicplayer.utils

import com.loveq.loveqmusicplayer.bean.LoveqMusicItem
import com.loveq.loveqmusicplayer.bean.LoveqProgram

/**
 * Created by Rc on 2020/5/14
 */

fun LoveqProgram.ProgramItem.toMusicItem(mediaId: String): LoveqMusicItem {
    return LoveqMusicItem(this.down_url, this.file_desc).apply {
        downloadCount = this@toMusicItem.download_num
        albumId = mediaId
        subAlbumId = ""
    }
}