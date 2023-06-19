package com.app.musicapp.presentation.ui.musicList.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.app.musicapp.common.listeners.MusicListSelectedListener
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.databinding.ListItemMusicWithImageBinding

class MusicListPagingViewHolder(private val binding : ListItemMusicWithImageBinding) :RecyclerView.ViewHolder(binding.root) {

    fun bind(data: MusicUiModel, musicListSelectedListener: MusicListSelectedListener) {
        binding.apply {
            artistIV.load(data.artworkUrl100)
            artistNameTv.text = data.artistName.toString()
            trackNameTv.text = data.trackName.toString()

            root.setOnClickListener {
                musicListSelectedListener.goDetail(data)
            }
        }
    }
}
