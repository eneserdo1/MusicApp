package com.app.musicapp.presentation.ui.musicHorizontalList.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.musicapp.R
import com.app.musicapp.common.constants.IntentKeys.Companion.SELECTED_MUSIC_FROM_LIST
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.common.utils.ProgressDialogUtil
import com.app.musicapp.databinding.FragmentMusicHorizontalListBinding
import com.app.musicapp.presentation.base.BaseFragment
import com.app.musicapp.presentation.ui.main.viewModel.MainViewModel
import com.app.musicapp.presentation.ui.musicHorizontalList.adapter.MusicHorizontalListAdapter
import com.app.musicapp.presentation.ui.musicHorizontalList.callback.MusicHorizontalListListener
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicHorizontalListFragment :
    BaseFragment<FragmentMusicHorizontalListBinding>(FragmentMusicHorizontalListBinding::inflate) {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var musicListAdapter: MusicHorizontalListAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }


    private fun initObservers() {
        viewModel.allMusicList().observe(viewLifecycleOwner) {
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
        musicListAdapter = MusicHorizontalListAdapter(object : MusicHorizontalListListener {
            override fun goDetail(item: MusicUiModel) {
                val bundle = Bundle().apply {
                    putParcelable(SELECTED_MUSIC_FROM_LIST,item)
                }
                findNavController().navigate(R.id.musicDetailFragment,bundle)
            }

            override fun delete(item: MusicUiModel) {
            }

        })
        musicListAdapter.submitList(it)
        binding.musicHorizontalListRv.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.musicHorizontalListRv.adapter = musicListAdapter
    }


    companion object {
        fun newInstance() = MusicHorizontalListFragment()
    }
}