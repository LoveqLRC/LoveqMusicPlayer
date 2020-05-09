package com.loveq.loveqmusicplayer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.loveq.loveqmusicplayer.musicservice.MusicService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showStandardNotification.setOnClickListener {
            val intent = Intent(this, MusicService::class.java)
            startService(intent)
        }
    }
}
