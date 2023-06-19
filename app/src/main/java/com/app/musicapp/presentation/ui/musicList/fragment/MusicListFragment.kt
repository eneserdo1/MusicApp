package com.app.musicapp.presentation.ui.musicList.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import com.app.musicapp.R
import com.app.musicapp.common.constants.IntentKeys
import com.app.musicapp.common.listeners.MusicListSelectedListener
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.common.utils.Alert.Companion.pagingErrorDialog
import com.app.musicapp.common.utils.Alert.Companion.showErrorPopup
import com.app.musicapp.common.utils.Alert.Companion.showPagingErrorPopup
import com.app.musicapp.common.utils.ProgressDialogUtil
import com.app.musicapp.databinding.FragmentMusicListBinding
import com.app.musicapp.presentation.base.BaseFragment
import com.app.musicapp.presentation.ui.main.viewModel.MainViewModel
import com.app.musicapp.presentation.ui.musicList.adapter.MusicListPagingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MusicListFragment :
    BaseFragment<FragmentMusicListBinding>(FragmentMusicListBinding::inflate) {

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var musicAdapter: MusicListPagingAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initAdapter()
        initAdapterLoader()
        initObservers()
    }

    private fun initObservers() {
        lifecycleScope.launch {
            viewModel.fetchMusicListPage().collect {
                musicAdapter.submitData(it)
            }
        }
    }

    private fun initAdapterLoader() {
        musicAdapter.addLoadStateListener { loadState ->
            if (loadState.refresh is LoadState.Loading) {
                ProgressDialogUtil.showProgress(requireContext())
            } else {
                ProgressDialogUtil.hideProgress()
                val errorState = when {
                    loadState.append is LoadState.Error -> loadState.append as LoadState.Error
                    loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
                    loadState.refresh is LoadState.Error -> {
                        loadState.refresh as LoadState.Error
                    }
                    else -> null
                }
                errorState?.let {

                }
            }
        }
    }

    private fun initAdapter() {
        musicAdapter = MusicListPagingAdapter(object : MusicListSelectedListener {
            override fun goDetail(item: MusicUiModel) {
                val bundle = Bundle().apply {
                    putParcelable(IntentKeys.SELECTED_MUSIC_FROM_LIST,item)
                }
                findNavController().navigate(R.id.action_musicListFragment_to_musicDetailFragment,bundle)
            }
        })
        binding.musicPagingRV.adapter = musicAdapter
    }


    companion object {
        fun newInstance() = MusicListFragment()
    }
}