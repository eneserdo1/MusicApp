package com.app.musicapp.presentation.ui.musicGridList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.app.musicapp.common.listeners.MusicListSelectedListener
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.databinding.ListItemMusicBinding
import com.app.musicapp.presentation.ui.musicGridList.adapter.viewholder.MusicGridViewHolder

class MusicListGridAdapter(private val musicListSelectedListener: MusicListSelectedListener) : ListAdapter<MusicUiModel, MusicGridViewHolder>(MusicDiffCallback) {

    private lateinit var binding: ListItemMusicBinding

    object MusicDiffCallback : DiffUtil.ItemCallback<MusicUiModel>() {
        override fun areItemsTheSame(oldItem: MusicUiModel, newItem: MusicUiModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MusicUiModel, newItem: MusicUiModel): Boolean {
            return oldItem.id == newItem.id
        }

    }


    override fun onBindViewHolder(holder: MusicGridViewHolder, position: Int) {
        holder.bind(getItem(position), musicListSelectedListener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicGridViewHolder {
        binding =
            ListItemMusicBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicGridViewHolder(binding)
    }
}