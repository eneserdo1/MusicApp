package com.app.musicapp.presentation.ui.musicCount.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.app.musicapp.R
import com.app.musicapp.common.constants.IntentKeys
import com.app.musicapp.common.listeners.MusicListSelectedListener
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.databinding.FragmentMusicCountBinding
import com.app.musicapp.presentation.base.BaseFragment
import com.app.musicapp.presentation.ui.main.viewModel.MainViewModel
import com.app.musicapp.presentation.ui.musicCount.adapter.MusicListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicCountFragment :
    BaseFragment<FragmentMusicCountBinding>(FragmentMusicCountBinding::inflate) {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var musicListAdapter: MusicListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    private fun initObservers() {
        viewModel.allMusicList().observe(viewLifecycleOwner) {
            binding.listCountTv.text = "${it.size} ${getString(R.string.adet_sonuc_bulundu)}"
            initAdapter(it)
        }
    }

    private fun initAdapter(it: List<MusicUiModel>?) {
        musicListAdapter = MusicListAdapter(object : MusicListSelectedListener {
            override fun goDetail(item: MusicUiModel) {
                val bundle = Bundle().apply {
                    putParcelable(IntentKeys.SELECTED_MUSIC_FROM_LIST, item)
                }
                findNavController().navigate(R.id.musicDetailFragment, bundle)
            }

        })
        musicListAdapter.submitList(it)
        binding.musicListRv.adapter = musicListAdapter
    }

    companion object {
        fun newInstance() = MusicCountFragment()

    }
}