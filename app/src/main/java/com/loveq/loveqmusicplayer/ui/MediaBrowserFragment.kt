package com.loveq.loveqmusicplayer.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.loveq.loveqmusicplayer.R
import com.loveq.loveqmusicplayer.utils.LoveqUtils
import com.loveq.playerlib.bean.BaseMusicItem
import kotlinx.android.synthetic.main.fragment_program_list.*

/**
 * Created by Rc on 2020/5/11
 */
class MediaBrowserFragment : Fragment() {

    lateinit var mMediaFragmentListener: MediaFragmentListener

    var mAdapter = MediaBrowserAdapter()

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
                    val baseMusicItem = BaseMusicItem(null, it, ROOT_MEDIA_ID)
                    baseMusicItem.musicArtist = it
                    mutableList.add(baseMusicItem)
                }
                programList[mediaId] = mutableList
            }
            mAdapter.updateList(mutableList)
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

    fun getProgramList(): MutableMap<String, ArrayList<BaseMusicItem>>
}

const val ROOT_MEDIA_KEY = "ROOT_MEDIA_KEY"

const val ROOT_MEDIA_ID: String = "/"