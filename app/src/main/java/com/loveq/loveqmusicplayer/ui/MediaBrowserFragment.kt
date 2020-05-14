package com.loveq.loveqmusicplayer.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.gson.Gson
import com.loveq.loveqmusicplayer.R
import com.loveq.loveqmusicplayer.bean.FILTER_KEY
import com.loveq.loveqmusicplayer.bean.LoveqMusicItem
import com.loveq.loveqmusicplayer.bean.ProgramFilter
import com.loveq.loveqmusicplayer.net.NetWorkManager
import com.loveq.loveqmusicplayer.net.SchedulerUtils
import com.loveq.loveqmusicplayer.utils.LoveqUtils
import com.loveq.loveqmusicplayer.utils.toMusicItem
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_program_list.*

/**
 * Created by Rc on 2020/5/11
 */
class MediaBrowserFragment : Fragment() {

    lateinit var mMediaFragmentListener: MediaFragmentListener

    var mAdapter = MediaBrowserAdapter { item, position ->
        mMediaFragmentListener.onMediaItemSelected(item, position)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_program_list, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mMediaFragmentListener = activity as MediaFragmentListener
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        list.adapter = mAdapter
        getData()
    }

    private fun getData() {
        val mediaId = getMediaId()
        val programList = mMediaFragmentListener.getProgramList()
        if (ROOT_MEDIA_ID == mediaId) {
            val mutableList = programList[mediaId] ?: ArrayList()
            if (mutableList.isEmpty()) {
                LoveqUtils.getProgramRange().forEach {
                    val musicItem = LoveqMusicItem("", it).apply {
                        albumId = ROOT_MEDIA_ID
                        subAlbumId = it
                    }
                    mutableList.add(musicItem)
                }
                programList[mediaId] = mutableList
            }
            mAdapter.updateList(mutableList)
        } else {
            val mutableList = programList[mediaId] ?: ArrayList()
            if (mutableList.isEmpty()) {
                val map = mutableMapOf<String, ProgramFilter>()
                val filter = ProgramFilter(1, 0, mediaId)
                map[FILTER_KEY] = filter
                val json = Gson().toJson(map)
                val disposable = NetWorkManager.service.getProgramList(json)
                    .flatMap { Observable.fromIterable(it.data) }
                    .map { it.toMusicItem(mediaId) }
                    .compose(SchedulerUtils.ioToMain())
                    .subscribe(
                        {
                            mutableList.add(it)
                        }, {

                        }, {
                            programList[mediaId] = mutableList
                            mAdapter.updateList(mutableList)
                        })
            } else {
                mAdapter.updateList(mutableList)
            }
        }

    }


    fun getMediaId(): String {
        return arguments!!.getString(ROOT_MEDIA_KEY)!!
    }


    companion object {

        fun newInstance(rootMediaKey: String): MediaBrowserFragment {
            val mediaBrowserFragment = MediaBrowserFragment()
            val args = Bundle().apply {
                putString(ROOT_MEDIA_KEY, rootMediaKey)
            }
            mediaBrowserFragment.arguments = args
            return mediaBrowserFragment
        }

    }
}


interface MediaFragmentListener {
    fun setToolbarTitle(title: CharSequence?)

    fun getProgramList(): MutableMap<String, ArrayList<LoveqMusicItem>>

    fun /**/onMediaItemSelected(item: LoveqMusicItem, position: Int)
}

const val ROOT_MEDIA_KEY = "ROOT_MEDIA_KEY"

const val ROOT_MEDIA_ID: String = "/"