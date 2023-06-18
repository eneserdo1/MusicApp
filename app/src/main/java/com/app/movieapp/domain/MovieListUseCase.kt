package com.app.movieapp.domain

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.app.movieapp.common.models.MovieUiModel
import com.app.movieapp.data.repository.Repository
import javax.inject.Inject

class MovieListUseCase @Inject constructor(private val repository: Repository) {


    fun allMovieList(): LiveData<List<MovieUiModel>> =
        Transformations.map(repository.allMovies()) { movieEntities ->
            MapMovieEntityToUIModel.mapResponseToEntity(movieEntities)
        }
}