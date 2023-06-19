package com.app.musicapp.data.repository

import androidx.lifecycle.LiveData
import com.app.musicapp.common.models.Result
import com.app.musicapp.common.utils.getCurrentDate
import com.app.musicapp.data.localDataSource.MusicDao
import com.app.musicapp.data.localDataSource.MusicEntity
import com.app.musicapp.data.localDataSource.SharedPreferencesHelper
import com.app.musicapp.data.models.MusicListResponseItem
import com.app.musicapp.data.remoteDataSource.RemoteDataSource
import com.app.musicapp.domain.MapMusicResponseToEntity.mapResponseToEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val musicDao: MusicDao,
    private val sharedPreferencesHelper: SharedPreferencesHelper
) {

    suspend fun getMusicList(): Flow<Result<MusicListResponseItem>> {
        val response = remoteDataSource.getMusicList()
        insertAll(response)
        return response
    }

    private suspend fun insertAll(movies: Flow<Result<MusicListResponseItem>>) {
        sharedPreferencesHelper.lastUpdateDate = getCurrentDate()
        movies.collect {
            if (it is Result.Success) {
                musicDao.deleteAllMusic()
                val entityList = mapResponseToEntity(it.data)
                musicDao.insertMusics(entityList)
            }
        }

    }

    fun allMusics(): LiveData<List<MusicEntity>> = musicDao.getAllMusics()

    suspend fun deleteMusic(trackId: Int) = musicDao.deleteWithTrackId(trackId)

}