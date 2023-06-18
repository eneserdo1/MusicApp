package com.app.musicapp.presentation.ui.musicList.fragment

import android.os.Bundle
import com.app.musicapp.databinding.FragmentMusicListBinding
import com.app.musicapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicListFragment :
    BaseFragment<FragmentMusicListBinding>(FragmentMusicListBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    companion object {
        fun newInstance() = MusicListFragment()
    }
}