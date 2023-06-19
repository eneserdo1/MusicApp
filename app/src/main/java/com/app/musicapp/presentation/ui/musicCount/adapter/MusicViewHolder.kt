package com.app.musicapp.presentation.ui.musicCount.adapter

import androidx.recyclerview.widget.RecyclerView
import com.app.musicapp.common.listeners.MusicListSelectedListener
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.databinding.ListItemMusicCountBinding

class MusicViewHolder(private val binding: ListItemMusicCountBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: MusicUiModel, musicListSelectedListener: MusicListSelectedListener) {
        binding.apply {
            artistNameTv.text = data.artistName.toString()
            trackNameTv.text = data.trackName.toString()

            root.setOnClickListener {
                musicListSelectedListener.goDetail(data)
            }
        }
    }
}
