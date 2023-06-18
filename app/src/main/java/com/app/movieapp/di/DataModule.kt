package com.app.movieapp.di

import android.content.Context
import androidx.room.Room
import com.app.movieapp.common.models.NetworkHelper
import com.app.movieapp.data.localDataSource.MovieDao
import com.app.movieapp.data.localDataSource.MovieDatabase
import com.app.movieapp.data.localDataSource.SharedPreferencesHelper
import com.app.movieapp.data.network.ApiService
import com.app.movieapp.data.remoteDataSource.RemoteDataSource
import com.app.movieapp.data.remoteDataSource.RemoteDataSourceImpl
import com.app.movieapp.data.repository.Repository
import com.app.movieapp.domain.MovieListUseCase
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
            movieDao: MovieDao,
            sharedPreferencesHelper: SharedPreferencesHelper
        ): Repository {
            return Repository(remoteDataSource, movieDao, sharedPreferencesHelper)
        }

        @Singleton
        @Provides
        fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MovieDatabase::class.java,
                "movie_database"
            ).build()
        }


        @Singleton
        @Provides
        fun provideDao(db: MovieDatabase) = db.movieDao()


        @Singleton
        @Provides
        fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferencesHelper {
            return SharedPreferencesHelper.getInstance(context)
        }

        @Singleton
        @Provides
        fun provideUseCase(repository: Repository): MovieListUseCase {
            return MovieListUseCase(repository)
        }

    }

}