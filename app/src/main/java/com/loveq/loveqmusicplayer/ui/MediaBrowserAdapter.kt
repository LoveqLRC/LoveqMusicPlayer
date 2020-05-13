package com.loveq.loveqmusicplayer.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.loveq.loveqmusicplayer.R
import com.loveq.playerlib.bean.BaseMusicItem
import kotlinx.android.synthetic.main.item_media_list.view.*

/**
 * Created by Rc on 2020/5/12
 */
class MediaBrowserAdapter : RecyclerView.Adapter<MediaBrowserAdapter.ViewHolder>() {

    val musicList = ArrayList<BaseMusicItem>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val musicName: TextView = view.musicName
        val musicArtist: TextView = view.musicArtist
        val playStatus: ImageView = view.play_status
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_media_list, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return musicList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val musicItem = musicList[position]
        if (musicItem.albumId == ROOT_MEDIA_ID) {
            holder.playStatus.visibility = View.GONE
        }
        holder.musicName.text = musicItem.musicName
        holder.musicArtist.text = musicItem.musicArtist
    }

    fun updateList(newDataList: ArrayList<BaseMusicItem>) {
        musicList.addAll(newDataList)
        notifyItemRangeInserted(musicList.size, newDataList.size)
    }
}