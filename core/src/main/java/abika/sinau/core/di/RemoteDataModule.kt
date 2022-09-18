package abika.sinau.core.di

import abika.sinau.core.data.source.remote.RemoteDataSource
import abika.sinau.core.data.source.remote.RemoteDataSourceImpl
import abika.sinau.core.data.source.remote.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * @author by Abika Chairul Yusri on 9/16/2022
 */

//@Module
//@InstallIn(SingletonComponent::class)
//object RemoteDataModule {
//
//    @Provides
//    fun provideRemoteDataSource(apiService: ApiService): RemoteDataSource {
//        return RemoteDataSourceImpl(apiService)
//    }
//}