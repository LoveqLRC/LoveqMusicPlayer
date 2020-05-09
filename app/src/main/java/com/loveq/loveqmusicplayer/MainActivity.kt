package com.loveq.loveqmusicplayer

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.loveq.loveqmusicplayer.bean.FILTER_KEY
import com.loveq.loveqmusicplayer.bean.ProgramFilter
import com.loveq.loveqmusicplayer.musicservice.MusicService
import com.loveq.loveqmusicplayer.net.NetWorkManager
import com.loveq.loveqmusicplayer.net.SchedulerUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        showStandardNotification.setOnClickListener {
//            val map = mutableMapOf<String, ProgramFilter>()
//            val filter = ProgramFilter(1, 0, 2020)
//            map[FILTER_KEY] = filter
//            val toJson = Gson().toJson(map)
//            NetWorkManager.service.getProgramList(toJson)
//                .compose(SchedulerUtils.ioToMain())
//                .subscribe({
//
//                }, {
//
//                })
//        }
    }
}
