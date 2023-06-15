package com.app.movieapp.presentation.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

abstract class BaseViewModel(private val appication: Application) : AndroidViewModel(appication) {

    var loading = MutableLiveData<Boolean>()
        protected set

    var error = MutableLiveData<Error>()
        protected set
}