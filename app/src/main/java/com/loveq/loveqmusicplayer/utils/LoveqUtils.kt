package com.loveq.loveqmusicplayer.utils

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Rc on 2020/5/9
 */
object LoveqUtils {

    fun getProgramRange(): ArrayList<Int> {

        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val programYearList = ArrayList<Int>()
        for (year in currentYear downTo 2003) {
            programYearList.add(year)
        }
        return programYearList
    }

}