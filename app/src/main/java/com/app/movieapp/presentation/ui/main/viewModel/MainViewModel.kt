package com.app.movieapp.presentation.ui.main.viewModel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.app.movieapp.common.models.MovieUiModel
import com.app.movieapp.common.models.Result
import com.app.movieapp.common.utils.getCurrentDate
import com.app.movieapp.data.localDataSource.SharedPreferencesHelper
import com.app.movieapp.data.repository.Repository
import com.app.movieapp.domain.MovieListUseCase
import com.app.movieapp.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository,
    private val sharedPreferencesHelper: SharedPreferencesHelper,
    private val movieUseCase: MovieListUseCase,
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
        fetchMovieList()
    }

    private fun fetchMovieList() {
        viewModelScope.launch {
            repository.getMovieList().collect {
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

    fun fetch(): LiveData<List<MovieUiModel>> {
        return movieUseCase.allMovieList()
    }

}