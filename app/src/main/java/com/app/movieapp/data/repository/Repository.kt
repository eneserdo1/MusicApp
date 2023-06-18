package com.app.movieapp.data.repository

import androidx.lifecycle.LiveData
import com.app.movieapp.common.models.Result
import com.app.movieapp.common.utils.getCurrentDate
import com.app.movieapp.data.localDataSource.MovieDao
import com.app.movieapp.data.localDataSource.MovieEntity
import com.app.movieapp.data.localDataSource.SharedPreferencesHelper
import com.app.movieapp.data.models.MovieListResponseItem
import com.app.movieapp.data.remoteDataSource.RemoteDataSource
import com.app.movieapp.domain.MapMovieResponseToEntity.mapResponseToEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class Repository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val movieDao: MovieDao,
    private val sharedPreferencesHelper: SharedPreferencesHelper
) {


    suspend fun getMovieList(
        pageNumber: String,
        pageSize: String
    ): Flow<Result<MovieListResponseItem>> {
        return remoteDataSource.getMovieList(pageNumber, pageSize)
    }

    suspend fun getMovieList(): Flow<Result<MovieListResponseItem>> {
        val response = remoteDataSource.getMovieList()
        insertAll(response)
        return response
    }

    private suspend fun insertAll(movies: Flow<Result<MovieListResponseItem>>) {
        sharedPreferencesHelper.lastUpdateDate = getCurrentDate()
        movies.collect {
            if (it is Result.Success) {
                movieDao.deleteAllMovies()
                val entityList = mapResponseToEntity(it.data)
                movieDao.insertMovies(entityList)
            }
        }

    }

    fun allMovies(): LiveData<List<MovieEntity>> = movieDao.getAllMovies()

}