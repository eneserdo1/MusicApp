package com.app.musicapp.data.network

import com.app.musicapp.data.models.MusicListResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {

    @GET("search")
    suspend fun getMusicList(@Query("term") term : String = "jack+johnson"): Response<MusicListResponseItem>


    @GET("search")
    suspend fun getMusicList(@QueryMap param: Map<String, String>): Response<MusicListResponseItem>
}