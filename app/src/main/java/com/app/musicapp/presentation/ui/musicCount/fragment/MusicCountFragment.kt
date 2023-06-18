package com.app.musicapp.presentation.ui.musicCount.fragment

import android.os.Bundle
import com.app.musicapp.databinding.FragmentMusicCountBinding
import com.app.musicapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicCountFragment : BaseFragment<FragmentMusicCountBinding>(FragmentMusicCountBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun newInstance() = MusicCountFragment()

    }
}