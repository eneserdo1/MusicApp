package com.app.musicapp.data.localDataSource

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [MusicEntity::class], version = 2, exportSchema = false)
abstract class MusicDatabase : RoomDatabase() {

    abstract fun musicDao(): MusicDao

}