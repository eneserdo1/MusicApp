package com.app.musicapp.data.remoteDataSource

import com.app.musicapp.common.utils.NetworkHelper
import com.app.musicapp.common.models.Result
import com.app.musicapp.data.base.BaseRemoteDataSource
import com.app.musicapp.data.models.MusicListResponseItem
import com.app.musicapp.data.network.ApiService
import com.app.musicapp.di.DispatcherProvider
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService,
    networkHelper: NetworkHelper,
    dispatcherProvider: DispatcherProvider
) :
    BaseRemoteDataSource(networkHelper, dispatcherProvider), RemoteDataSource {

    override suspend fun getMusicList(
        pageNumber: String,
        pageSize: String
    ): Flow<Result<MusicListResponseItem>> {
        val params: HashMap<String, String> = HashMap<String, String>().also {
            it["offset"] = pageNumber
            it["limit"] = pageSize
        }
        return baseRequestFlow {
            apiService.getMusicList(params)
        }
    }

    override suspend fun getMusicList(): Flow<Result<MusicListResponseItem>> {
        return baseRequestFlow {
            apiService.getMusicList()
        }
    }
}