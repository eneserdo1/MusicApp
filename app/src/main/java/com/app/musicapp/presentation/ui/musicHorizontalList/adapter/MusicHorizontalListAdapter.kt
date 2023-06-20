package com.app.musicapp.presentation.ui.musicHorizontalList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.databinding.ListItemMusicHorizontalBinding
import com.app.musicapp.presentation.ui.musicHorizontalList.adapter.viewholder.MusicHorizontalViewHolder
import com.app.musicapp.presentation.ui.musicHorizontalList.callback.MusicHorizontalListListener

class MusicHorizontalListAdapter(private val musicHorizontalListListener: MusicHorizontalListListener) : ListAdapter<MusicUiModel, MusicHorizontalViewHolder>(MusicDiffCallback) {

    private lateinit var binding: ListItemMusicHorizontalBinding

    object MusicDiffCallback : DiffUtil.ItemCallback<MusicUiModel>() {
        override fun areItemsTheSame(oldItem: MusicUiModel, newItem: MusicUiModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: MusicUiModel, newItem: MusicUiModel): Boolean {
            return oldItem.id == newItem.id
        }

    }


    override fun onBindViewHolder(holder: MusicHorizontalViewHolder, position: Int) {
        holder.bind(getItem(position), musicHorizontalListListener)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHorizontalViewHolder {
        binding = ListItemMusicHorizontalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MusicHorizontalViewHolder(binding)
    }
}