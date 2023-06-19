package com.app.musicapp.data.remoteDataSource

import com.app.musicapp.common.models.Result
import com.app.musicapp.data.models.MusicListResponseItem
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getMusicList(): Flow<Result<MusicListResponseItem>>

}