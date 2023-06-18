package com.app.musicapp.presentation.ui.musicGridList.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.app.musicapp.R
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.common.utils.ProgressDialogUtil
import com.app.musicapp.databinding.FragmentMusicGridListBinding
import com.app.musicapp.presentation.base.BaseFragment
import com.app.musicapp.presentation.ui.main.viewModel.MainViewModel
import com.app.musicapp.presentation.ui.musicCount.adapter.MusicListAdapter
import com.app.musicapp.presentation.ui.musicGridList.adapter.MusicListGridAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicGridListFragment :
    BaseFragment<FragmentMusicGridListBinding>(FragmentMusicGridListBinding::inflate) {

    private val viewModel : MainViewModel by activityViewModels()

    private lateinit var musicListAdapter : MusicListGridAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        viewModel.allMusicList().observe(viewLifecycleOwner) {
            initAdapter(it)
        }
    }

    private fun initAdapter(it: List<MusicUiModel>?) {
        musicListAdapter = MusicListGridAdapter()
        musicListAdapter.submitList(it)
        binding.gridMusicRV.adapter = musicListAdapter
    }

    companion object {
        fun newInstance() = MusicGridListFragment()
    }
}