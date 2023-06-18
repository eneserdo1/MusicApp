package com.app.musicapp.presentation.ui.musicHorizontalList.callback

import com.app.musicapp.common.models.MusicUiModel

interface MusicHorizontalListListener {

    fun goDetail(item : MusicUiModel)

    fun delete(item : MusicUiModel)
}