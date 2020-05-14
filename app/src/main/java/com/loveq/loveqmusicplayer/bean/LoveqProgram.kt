package com.loveq.loveqmusicplayer.bean

/**
 * Created by Rc on 2020/5/9
 */
class LoveqProgram {
    lateinit var status: Status
    lateinit var paginated: Paginated
    lateinit var data: List<ProgramItem>

    data class ProgramItem(
        var file_desc: String,//节目描述 2016.12.25 圣诞节战场上的一个小故事
        var lang: String,//语言
        var id: String,
        var file_name: String,//文件名
        var attach_file: String,//直播路径
        var down_url: String,//下载路径
        var download_num: Int,//下载数量
        var file_txt: String//当期节目 圣诞节战场上的一个小故事
    )

    data class Status(var success: Int)

    data class Paginated(
        var total: Int,
        var count: Int,
        var more: Int
    )

}