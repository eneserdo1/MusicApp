package com.app.musicapp.presentation.ui.musicGridList.fragment

import android.os.Bundle
import com.app.musicapp.databinding.FragmentMusicGridListBinding
import com.app.musicapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicGridListFragment :
    BaseFragment<FragmentMusicGridListBinding>(FragmentMusicGridListBinding::inflate) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    companion object {
        fun newInstance() = MusicGridListFragment()
    }
}