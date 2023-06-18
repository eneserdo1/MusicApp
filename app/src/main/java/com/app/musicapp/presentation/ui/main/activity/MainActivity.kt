package com.app.musicapp.presentation.ui.main.activity

import android.os.Bundle
import androidx.activity.viewModels
import com.app.musicapp.databinding.ActivityMainBinding
import com.app.musicapp.presentation.base.BaseActivity
import com.app.musicapp.presentation.ui.main.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {


    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}