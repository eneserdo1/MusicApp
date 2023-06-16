package com.app.movieapp.di

import com.app.movieapp.common.models.NetworkHelper
import com.app.movieapp.data.network.ApiService
import com.app.movieapp.data.remoteDataSource.RemoteDataSource
import com.app.movieapp.data.remoteDataSource.RemoteDataSourceImpl
import com.app.movieapp.data.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
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
        ): Repository {
            return Repository(remoteDataSource)
        }

    }

}