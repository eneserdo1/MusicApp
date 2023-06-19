package com.app.musicapp.presentation.ui.main.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.*
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.common.utils.getCurrentDate
import com.app.musicapp.data.localDataSource.SharedPreferencesHelper
import com.app.musicapp.data.remoteDataSource.PagingDataSource
import com.app.musicapp.data.remoteDataSource.PagingDataSource.Companion.NETWORK_PAGE_SIZE
import com.app.musicapp.data.repository.Repository
import com.app.musicapp.domain.MapMusicResponseToUIModel
import com.app.musicapp.domain.MusicListUseCase
import com.app.musicapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val musicUseCase: MusicListUseCase,
    private val pagingDataSource: PagingDataSource,
    application: Application
) : BaseViewModel(application) {

    init {
        fetchMusicList()
    }

    fun fetchMusicList() {
        val lastUpdatedDate = sharedPreferencesHelper.lastUpdateDate
        val currentDate = getCurrentDate()

        if (lastUpdatedDate == currentDate) {
            return
        }
        viewModelScope.launch {
            repository.getMusicList().collect {
                parseResponse(it)
            }
        }
    }

    fun allMusicList(): LiveData<List<MusicUiModel>> {
        return musicUseCase.allMusicList()
    }

    fun deleteMusic(music: MusicUiModel) {
        viewModelScope.launch {
            music.trackId?.let {
                repository.deleteMusic(it)
            }
        }
    }

    fun fetchMusicListPage(): Flow<PagingData<MusicUiModel>> {
        val flow = Pager(
            PagingConfig(pageSize = NETWORK_PAGE_SIZE)
        ) {
            pagingDataSource
        }.flow
            .map { pagingData ->
                pagingData.map { response ->
                    MapMusicResponseToUIModel.mapMusicResponseToUIModel(
                        response
                    )
                }
            }
            .cachedIn(viewModelScope)
        return flow
    }

    fun refreshData() {
        fetchMusicListPage()
        fetchMusicList()
    }

}