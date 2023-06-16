package com.app.movieapp.data.remoteDataSource

import com.app.movieapp.data.models.MovieListResponseItem
import kotlinx.coroutines.flow.Flow
import com.app.movieapp.common.models.Result

interface RemoteDataSource {

    suspend fun getMovieList(pageNumber: String,
                             pageSize: String) : Flow<Result<MovieListResponseItem>>

    suspend fun getMovieList() : Flow<Result<MovieListResponseItem>>

}