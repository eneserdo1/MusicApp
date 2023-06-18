package com.app.musicapp.presentation.ui.musicHorizontalList.fragment

import android.os.Bundle
import com.app.musicapp.databinding.FragmentMusicHorizontalListBinding
import com.app.musicapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicHorizontalListFragment :
    BaseFragment<FragmentMusicHorizontalListBinding>(FragmentMusicHorizontalListBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun newInstance() = MusicHorizontalListFragment()
    }
}