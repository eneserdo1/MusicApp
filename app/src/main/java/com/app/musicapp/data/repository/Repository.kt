package com.app.musicapp.data.repository

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.app.musicapp.common.models.Result
import com.app.musicapp.common.utils.getCurrentDate
import com.app.musicapp.data.localDataSource.MusicDao
import com.app.musicapp.data.localDataSource.MusicEntity
import com.app.musicapp.data.localDataSource.SharedPreferencesHelper
import com.app.musicapp.data.models.MusicListResponseItem
import com.app.musicapp.data.remoteDataSource.PagingDataSource
import com.app.musicapp.data.remoteDataSource.RemoteDataSource
import com.app.musicapp.domain.MapMusicResponseToEntity.mapResponseToEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val musicDao: MusicDao,
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val pagingDataSource: PagingDataSource
) {

    fun fetchMusicListPage(): Flow<PagingData<com.app.musicapp.data.models.Result>> {
        val flow = Pager(
            PagingConfig(pageSize = PagingDataSource.NETWORK_PAGE_SIZE)
        ) {
            pagingDataSource
        }.flow
        return flow
    }

    suspend fun getMusicList(): Flow<Result<MusicListResponseItem>> {
        val response = remoteDataSource.getMusicList()
        insertAll(response)
        return response
    }

    private suspend fun insertAll(movies: Flow<Result<MusicListResponseItem>>) {
        movies.collect {
            if (it is Result.Success) {
                sharedPreferencesHelper.lastUpdateDate = getCurrentDate()
                musicDao.deleteAllMusic()
                val entityList = mapResponseToEntity(it.data)
                musicDao.insertMusics(entityList)
            }
        }

    }

    fun allMusics(): LiveData<List<MusicEntity>> = musicDao.getAllMusics()

    suspend fun deleteMusic(trackId: Int) = musicDao.deleteWithTrackId(trackId)

}