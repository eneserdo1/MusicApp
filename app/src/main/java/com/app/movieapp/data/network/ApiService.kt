package com.app.movieapp.data.network

import com.app.movieapp.data.models.MovieListResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ApiService {

    @GET("search")
    suspend fun getMovieList(@Query("term") term : String = "jack+johnson"): Response<MovieListResponseItem>


    @GET("search")
    suspend fun getMovieList(@QueryMap param: Map<String, String>): Response<MovieListResponseItem>
}