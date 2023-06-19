package com.app.musicapp.common.listeners

import com.app.musicapp.common.models.MusicUiModel

interface MusicListSelectedListener {

    fun goDetail(item: MusicUiModel)
}