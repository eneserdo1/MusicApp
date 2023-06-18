package com.app.musicapp.presentation.ui.musicDetail.fragment

import android.os.Bundle
import com.app.musicapp.databinding.FragmentMusicDetailBinding
import com.app.musicapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicDetailFragment :
    BaseFragment<FragmentMusicDetailBinding>(FragmentMusicDetailBinding::inflate) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun newInstance() = MusicDetailFragment()
    }
}