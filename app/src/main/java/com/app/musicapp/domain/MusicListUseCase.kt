package com.app.musicapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.paging.PagingData
import androidx.paging.map
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.data.repository.Repository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MusicListUseCase @Inject constructor(private val repository: Repository) {


    fun allMusicList(): LiveData<List<MusicUiModel>> =
        repository.allMusics().map { musicEntities ->
            MapMusicEntityToUIModel.mapEntityToUiModel(musicEntities)
        }

    fun musicListWithPagination(): Flow<PagingData<MusicUiModel>> {
        return repository.fetchMusicListPage().map { pagingData ->
            pagingData.map { result ->
                MapMusicResponseToUIModel.mapMusicResponseToUIModel(
                    result
                )
            }
        }
    }
}