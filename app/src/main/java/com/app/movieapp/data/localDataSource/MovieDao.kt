package com.app.movieapp.data.localDataSource

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie_table")
    fun getAllMovies(): LiveData<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM movie_table WHERE trackId = :trackId ")
    suspend fun deleteWithTrackId(trackId: Int)

    @Query("SELECT COUNT(*) FROM movie_table")
    suspend fun getMovieCount(): Int

    @Query("DELETE FROM movie_table")
    suspend fun deleteAllMovies()
}