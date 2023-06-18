package com.app.musicapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.app.musicapp.common.models.MusicUiModel
import com.app.musicapp.data.repository.Repository
import javax.inject.Inject

class MusicListUseCase @Inject constructor(private val repository: Repository) {


    fun allMusicList(): LiveData<List<MusicUiModel>> =
        Transformations.map(repository.allMusics()) { musicEntities ->
            MapMusicEntityToUIModel.mapEntityToUiModel(musicEntities)
        }
}