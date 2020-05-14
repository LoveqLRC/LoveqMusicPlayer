package com.loveq.loveqmusicplayer.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.loveq.loveqmusicplayer.R

/**
 * Created by Rc on 2020/5/9
 */
class PlaybackControlsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_playback_controls, container, false)
        return view
    }


}