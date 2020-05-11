package com.loveq.loveqmusicplayer.utils

import java.util.*
import kotlin.collections.ArrayList

/**
 * Created by Rc on 2020/5/9
 */
object LoveqUtils {

    fun getProgramRange(): ArrayList<String> {

        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val programYearList = ArrayList<String>()
        for (year in currentYear downTo 2003) {
            programYearList.add(year.toString())
        }
        return programYearList
    }

}