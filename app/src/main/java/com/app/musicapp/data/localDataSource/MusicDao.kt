package com.app.musicapp.data.localDataSource

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MusicDao {

    @Query("SELECT * FROM music_table")
    fun getAllMusics(): LiveData<List<MusicEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMusics(musics: List<MusicEntity>)

    @Query("DELETE FROM music_table WHERE trackId = :trackId ")
    suspend fun deleteWithTrackId(trackId: Int)

    @Query("SELECT COUNT(*) FROM music_table")
    suspend fun getMusicCount(): Int

    @Query("DELETE FROM music_table")
    suspend fun deleteAllMusic()
}