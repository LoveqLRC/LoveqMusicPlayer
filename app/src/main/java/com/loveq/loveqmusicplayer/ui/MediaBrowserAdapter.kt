package com.loveq.loveqmusicplayer.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.loveq.loveqmusicplayer.R
import com.loveq.loveqmusicplayer.bean.LoveqMusicItem
import com.loveq.playerlib.bean.BaseMusicItem
import kotlinx.android.synthetic.main.item_media_list.view.*

/**
 * Created by Rc on 2020/5/12
 */
class MediaBrowserAdapter(var listener: (LoveqMusicItem, Int) -> Unit) :
    RecyclerView.Adapter<MediaBrowserAdapter.ViewHolder>() {

    val musicList = ArrayList<LoveqMusicItem>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val musicName: TextView = view.musicName
        val musicDownCount: TextView = view.musicDownCount
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
            holder.musicDownCount.visibility = View.GONE
            holder.musicName.text =
                holder.itemView.resources.getString(R.string.program_year, musicItem.musicName)
        } else {
            holder.musicName.text = musicItem.musicName
            holder.musicDownCount.text =
                holder.itemView.resources.getString(
                    R.string.program_down_load_count,
                    musicItem.downloadCount
                )
        }


        holder.itemView.setOnClickListener {
            listener(musicItem, holder.adapterPosition)
        }
    }

    fun updateList(newDataList: ArrayList<LoveqMusicItem>) {
        musicList.addAll(newDataList)
        notifyItemRangeInserted(musicList.size, newDataList.size)
    }
}