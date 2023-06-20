package com.app.musicapp.presentation.ui.main.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.common.utils.getCurrentDate
import com.app.musicapp.data.localDataSource.SharedPreferencesHelper
import com.app.musicapp.data.repository.Repository
import com.app.musicapp.domain.MusicListUseCase
import com.app.musicapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val musicUseCase: MusicListUseCase,
    application: Application
) : BaseViewModel(application) {

    init {
        fetchMusicList()
    }

    private fun fetchMusicList() {
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
        return musicUseCase.musicListWithPagination().cachedIn(viewModelScope)
    }

    fun refreshMusicData() {
        fetchMusicList()
    }

    fun setError(it: Throwable) {
        error.value = it
    }

}