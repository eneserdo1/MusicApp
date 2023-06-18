package com.app.musicapp.presentation.ui.musicCount.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.databinding.ListItemMusicCountBinding

class MusicListAdapter : ListAdapter<MusicUiModel, MusicViewHolder>(MusicDiffCallback) {

    private lateinit var binding: ListItemMusicCountBinding

    object MusicDiffCallback : DiffUtil.ItemCallback<MusicUiModel>() {
        override fun areItemsTheSame(oldItem: MusicUiModel, newItem: MusicUiModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MusicUiModel, newItem: MusicUiModel): Boolean {
            return oldItem.id == newItem.id
        }

    }


    override fun onBindViewHolder(holder: MusicViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicViewHolder {
        binding =
            ListItemMusicCountBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicViewHolder(binding)
    }
}