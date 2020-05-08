package com.loveq.loveqmusicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.loveq.playerlib.helper.MediaPlayerHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        play.setOnClickListener {
            MediaPlayerHelper.getInstance().play("http://dl.loveq.cn/program/2020/2020.05.02.mp3")
        }
    }
}
