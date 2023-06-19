package com.app.musicapp.di

import android.content.Context
import androidx.room.Room
import com.app.musicapp.common.utils.NetworkHelper
import com.app.musicapp.data.localDataSource.MusicDao
import com.app.musicapp.data.localDataSource.MusicDatabase
import com.app.musicapp.data.localDataSource.SharedPreferencesHelper
import com.app.musicapp.data.network.ApiService
import com.app.musicapp.data.remoteDataSource.PagingDataSource
import com.app.musicapp.data.remoteDataSource.RemoteDataSource
import com.app.musicapp.data.remoteDataSource.RemoteDataSourceImpl
import com.app.musicapp.data.repository.Repository
import com.app.musicapp.domain.MusicListUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {


    @Binds
    abstract fun provideDispatchers(dispatcherImpl: DispatcherImpl): DispatcherProvider


    companion object {
        @Provides
        @Singleton
        fun provideRemoteDataSource(
            apiService: ApiService,
            networkHelper: NetworkHelper,
            dispatcherProvider: DispatcherProvider
        ): RemoteDataSource {
            return RemoteDataSourceImpl(apiService, networkHelper, dispatcherProvider)
        }

        @Provides
        @Singleton
        fun provideRepository(
            remoteDataSource: RemoteDataSource,
            musicDao: MusicDao,
            sharedPreferencesHelper: SharedPreferencesHelper
        ): Repository {
            return Repository(remoteDataSource, musicDao, sharedPreferencesHelper)
        }

        @Singleton
        @Provides
        fun provideMusicDatabase(@ApplicationContext context: Context): MusicDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MusicDatabase::class.java,
                "music_database"
            ).build()
        }


        @Singleton
        @Provides
        fun provideDao(db: MusicDatabase) = db.musicDao()


        @Singleton
        @Provides
        fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferencesHelper {
            return SharedPreferencesHelper.getInstance(context)
        }

        @Singleton
        @Provides
        fun provideUseCase(repository: Repository): MusicListUseCase {
            return MusicListUseCase(repository)
        }

        @Singleton
        @Provides
        fun providePagingDataSource(apiService: ApiService): PagingDataSource {
            return PagingDataSource(apiService)
        }

    }

}