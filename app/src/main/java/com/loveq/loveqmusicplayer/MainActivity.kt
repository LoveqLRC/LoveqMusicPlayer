package com.loveq.loveqmusicplayer

import android.os.Bundle
import android.text.TextUtils
import androidx.appcompat.app.AppCompatActivity
import com.loveq.loveqmusicplayer.bean.LoveqMusicItem
import com.loveq.loveqmusicplayer.ui.MediaBrowserFragment
import com.loveq.loveqmusicplayer.ui.MediaFragmentListener
import com.loveq.loveqmusicplayer.ui.ROOT_MEDIA_ID
import com.loveq.playerlib.bean.BaseMusicItem
import kotlinx.android.synthetic.main.include_toolbar.*

class MainActivity : AppCompatActivity(), MediaFragmentListener {

    private val browserTree = mutableMapOf<String, ArrayList<LoveqMusicItem>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar.title = resources.getString(R.string.title_app)
        setSupportActionBar(toolbar)
        navigateToBrowser(ROOT_MEDIA_ID)
    }


    private fun navigateToBrowser(mediaId: String) {
        var browseFragment = getBrowseFragment()
        if (browseFragment == null || !TextUtils.equals(browseFragment.getMediaId(), mediaId)) {
            browseFragment = MediaBrowserFragment.newInstance(mediaId)
            val transaction = supportFragmentManager.beginTransaction()
            transaction.setCustomAnimations(
                R.animator.slide_in_from_right, R.animator.slide_out_to_left,
                R.animator.slide_in_from_left, R.animator.slide_out_to_right
            )

            transaction.replace(R.id.container, browseFragment, FRAGMENT_TAG)
            if (mediaId != ROOT_MEDIA_ID) {
                transaction.addToBackStack(null)
            }
            transaction.commit()
        } else {
            //TODO 播放音乐
        }

    }


    private fun getBrowseFragment(): MediaBrowserFragment? {
        return supportFragmentManager.findFragmentByTag(FRAGMENT_TAG) as MediaBrowserFragment?
    }

    override fun setToolbarTitle(title: CharSequence?) {
        toolbar.title = title
    }

    override fun getProgramList(): MutableMap<String, ArrayList<LoveqMusicItem>> = browserTree

    override fun onMediaItemSelected(
        item: LoveqMusicItem,
        position: Int
    ) {
        navigateToBrowser(item.subAlbumId)
    }


}

const val FRAGMENT_TAG = "MediaBrowserFragment"
