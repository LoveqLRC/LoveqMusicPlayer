package com.loveq.loveqmusicplayer.bean

/**
 * Created by Rc on 2020/5/9
 */
class ProgramFilter(
    var lang: Int,
    var month: Int,
    var year: String,
    var sort_by: String = "id_desc"
)

const val FILTER_KEY = "prog_filter"