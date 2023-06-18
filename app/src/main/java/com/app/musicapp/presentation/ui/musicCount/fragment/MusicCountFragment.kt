package com.app.musicapp.presentation.ui.musicCount.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import com.app.musicapp.R
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.common.utils.ProgressDialogUtil
import com.app.musicapp.databinding.FragmentMusicCountBinding
import com.app.musicapp.presentation.base.BaseFragment
import com.app.musicapp.presentation.ui.main.viewModel.MainViewModel
import com.app.musicapp.presentation.ui.musicCount.adapter.MusicListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicCountFragment : BaseFragment<FragmentMusicCountBinding>(FragmentMusicCountBinding::inflate) {

    private val viewModel : MainViewModel by activityViewModels()

    private lateinit var musicListAdapter : MusicListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        viewModel.allMusicList().observe(viewLifecycleOwner) {
            binding.listCountTv.text = "${it.size} ${getString(R.string.adet_sonuc_bulundu)}"
            initAdapter(it)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            if (it) {
                ProgressDialogUtil.showProgress(requireContext())
            } else {
                ProgressDialogUtil.hideProgress()
            }
        }
    }

    private fun initAdapter(it: List<MusicUiModel>?) {
        musicListAdapter = MusicListAdapter()
        musicListAdapter.submitList(it)
        binding.musicListRv.adapter = musicListAdapter
    }

    companion object {
        fun newInstance() = MusicCountFragment()

    }
}