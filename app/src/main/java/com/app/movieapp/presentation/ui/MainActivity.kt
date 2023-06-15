package com.app.movieapp.presentation.ui

import android.os.Bundle
import com.app.movieapp.databinding.ActivityMainBinding
import com.app.movieapp.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}