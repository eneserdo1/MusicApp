package com.app.musicapp.presentation.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.app.musicapp.common.models.Result
import com.app.musicapp.data.models.MusicListResponseItem

abstract class BaseViewModel(private val appication: Application) : AndroidViewModel(appication) {

    var loading = MutableLiveData<Boolean>()
        protected set

    var error = MutableLiveData<Throwable?>()
        protected set


    fun parseResponse(response: Result<MusicListResponseItem>) {
        when (response) {
            is Result.Success -> {
                loading.value = false
            }
            is Result.Loading -> {
                loading.value = true
            }
            is Result.Error -> {
                loading.value = false
                error.value = response.throwable
            }
        }
    }
}