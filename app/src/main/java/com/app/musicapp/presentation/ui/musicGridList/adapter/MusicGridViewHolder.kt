package com.app.musicapp.presentation.ui.musicGridList.adapter

import androidx.recyclerview.widget.RecyclerView
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.databinding.ListItemMusicCountBinding

class MusicGridViewHolder(private val binding : ListItemMusicCountBinding) :RecyclerView.ViewHolder(binding.root) {

    fun bind(data : MusicUiModel) {
        binding.apply {
            artistNameTv.text = data.artistName.toString()
            trackNameTv.text = data.trackName.toString()
        }
    }
}