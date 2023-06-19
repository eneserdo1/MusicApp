package com.app.musicapp.presentation.ui.musicList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.app.musicapp.common.listeners.MusicListSelectedListener
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.databinding.ListItemMusicWithImageBinding

class MusicListPagingAdapter(private val musicListSelectedListener: MusicListSelectedListener) :
    PagingDataAdapter<MusicUiModel, MusicListPagingViewHolder>(DiffUtilCallback) {

    private lateinit var binding: ListItemMusicWithImageBinding


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicListPagingViewHolder {
        binding = ListItemMusicWithImageBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MusicListPagingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MusicListPagingViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, musicListSelectedListener) }
    }


    object DiffUtilCallback : DiffUtil.ItemCallback<MusicUiModel>() {

        override fun areItemsTheSame(oldItem: MusicUiModel, newItem: MusicUiModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MusicUiModel, newItem: MusicUiModel): Boolean {
            return oldItem.trackId == newItem.trackId
        }
    }
}