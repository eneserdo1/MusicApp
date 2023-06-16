package com.app.movieapp.data.repository

import com.app.movieapp.common.models.Result
import com.app.movieapp.data.models.MovieListResponseItem
import com.app.movieapp.data.remoteDataSource.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(private val remoteDataSource: RemoteDataSource) {

    suspend fun getMovieList(): Flow<Result<MovieListResponseItem>> {
        return remoteDataSource.getMovieList()
    }

    suspend fun getMovieList(
        pageNumber: String,
        pageSize: String
    ): Flow<Result<MovieListResponseItem>> {
        return remoteDataSource.getMovieList(pageNumber, pageSize)
    }
}