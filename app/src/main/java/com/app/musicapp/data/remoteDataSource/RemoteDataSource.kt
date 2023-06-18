package com.app.musicapp.data.remoteDataSource

import com.app.musicapp.data.models.MusicListResponseItem
import kotlinx.coroutines.flow.Flow
import com.app.musicapp.common.models.Result

interface RemoteDataSource {

    suspend fun getMusicList(pageNumber: String,
                             pageSize: String) : Flow<Result<MusicListResponseItem>>

    suspend fun getMusicList() : Flow<Result<MusicListResponseItem>>

}