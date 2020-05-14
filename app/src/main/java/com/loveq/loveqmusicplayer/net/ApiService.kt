package com.loveq.loveqmusicplayer.net

import com.loveq.loveqmusicplayer.bean.LoveqProgram
import io.reactivex.Observable
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by Rc on 2020/5/9
 */
interface ApiService {
    @POST("/")
    @FormUrlEncoded
    fun getProgramList(
        @Field("json") programFilter: String,
        @Query("url") url: String = "program/list"
    ): Observable<LoveqProgram>
}