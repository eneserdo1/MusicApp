package com.app.musicapp.presentation.ui.musicDetail.fragment

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import coil.load
import com.app.musicapp.common.constants.IntentKeys.Companion.SELECTED_MUSIC_FROM_LIST
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.databinding.FragmentMusicDetailBinding
import com.app.musicapp.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MusicDetailFragment :
    BaseFragment<FragmentMusicDetailBinding>(FragmentMusicDetailBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val musicDetailModel = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            requireArguments().getParcelable(SELECTED_MUSIC_FROM_LIST, MusicUiModel::class.java)
        } else {
            requireArguments().getParcelable(SELECTED_MUSIC_FROM_LIST)
        }

        initUI(musicDetailModel)
        initButtonsListener()
    }

    private fun initButtonsListener() {
        binding.toolbarBackButton.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun initUI(musicDetailModel: MusicUiModel?) {
        musicDetailModel?.let { data ->
            binding.apply {
                trackIV.load(data.artworkUrl100)
                artistNameTv.text = data.artistName.toString()
                trackNameTv.text = data.trackName.toString()
                collectionNameTv.text = data.collectionName.toString()
                priceNameTv.text = "₺ ${data.trackPrice.toString()}"
                releaseDateTv.text = data.releaseDate.toString()
            }
        }
    }

    companion object {
        fun newInstance() = MusicDetailFragment()
    }
}