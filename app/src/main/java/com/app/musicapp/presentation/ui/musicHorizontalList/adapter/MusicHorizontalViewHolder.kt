package com.app.musicapp.presentation.ui.musicHorizontalList.adapter

import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.databinding.ListItemMusicHorizontalBinding
import com.app.musicapp.presentation.ui.musicHorizontalList.callback.MusicHorizontalListListener

class MusicHorizontalViewHolder(private val binding: ListItemMusicHorizontalBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(data: MusicUiModel, musicHorizontalListListener: MusicHorizontalListListener) {
        binding.apply {
            artistNameTv.text = data.artistName.toString()
            trackNameTv.text = data.trackName.toString()
            releaseDateTv.text = data.releaseDate.toString()
            trackPriceTv.text = "₺ ${data.trackPrice.toString()}"
            artistIV.load(data.artworkUrl100)

            root.setOnClickListener {
                musicHorizontalListListener.goDetail(data)
            }

            deleteIV.setOnClickListener {
                musicHorizontalListListener.delete(data)
            }
        }
    }
}
