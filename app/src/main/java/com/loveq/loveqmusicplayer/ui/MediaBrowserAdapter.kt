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
 * Created by Rc on 2020/5/11
 */

class MediaBrowserAdapter : RecyclerView.Adapter<MediaBrowserAdapter.ViewHolder>() {
    val dataList = ArrayList<BaseMusicItem>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val description: TextView = view.description
        val title: TextView = view.title
        val imageView: ImageView = view.play_eq
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val baseMusicItem = dataList[position]
        holder.description.text = baseMusicItem.musicDescription
        holder.title.text = baseMusicItem.musicTitle

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_media_list, parent, false)
        )
    }

    fun updateList(mutableList: MutableList<BaseMusicItem>) {
        dataList.addAll(mutableList)
        notifyDataSetChanged()
    }


}