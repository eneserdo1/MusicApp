package com.app.musicapp.presentation.ui.main.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.common.models.Result
import com.app.musicapp.common.utils.getCurrentDate
import com.app.musicapp.data.localDataSource.SharedPreferencesHelper
import com.app.musicapp.data.repository.Repository
import com.app.musicapp.domain.MusicListUseCase
import com.app.musicapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
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
        checkDataUpdatedState()
    }

    private fun checkDataUpdatedState() {
        val lastUpdatedDate = sharedPreferencesHelper.lastUpdateDate
        val currentDate = getCurrentDate()

        if (lastUpdatedDate == currentDate) {
            return
        }
        fetchMusicList()
    }

    private fun fetchMusicList() {
        viewModelScope.launch {
            repository.getMusicList().collect {
                when (it) {
                    is Result.Success -> {}
                    is Result.Loading -> {
                        loading.value = true
                    }
                    is Result.Error -> {
                        error.value = it.throwable
                    }
                }
            }
        }
    }

    fun allMusicList(): LiveData<List<MusicUiModel>> {
        return musicUseCase.allMusicList()
    }

}