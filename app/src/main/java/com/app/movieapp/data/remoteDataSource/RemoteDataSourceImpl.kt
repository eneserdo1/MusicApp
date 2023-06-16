package com.app.movieapp.data.remoteDataSource

import com.app.movieapp.common.models.NetworkHelper
import com.app.movieapp.common.models.Result
import com.app.movieapp.data.base.BaseRemoteDataSource
import com.app.movieapp.data.models.MovieListResponseItem
import com.app.movieapp.data.network.ApiService
import com.app.movieapp.di.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    networkHelper: NetworkHelper,
    dispatcherProvider: DispatcherProvider
) :
    BaseRemoteDataSource(networkHelper, dispatcherProvider), RemoteDataSource {

    override suspend fun getMovieList(
        pageNumber: String,
        pageSize: String
    ): Flow<Result<MovieListResponseItem>> {
        val params: HashMap<String, String> = HashMap<String, String>().also {
            it["offset"] = pageNumber
            it["limit"] = pageSize
        }
        return baseRequestFlow {
            apiService.getMovieList(params)
        }
    }

    override suspend fun getMovieList(): Flow<Result<MovieListResponseItem>> {
        return baseRequestFlow {
            apiService.getMovieList()
        }
    }
}