package abika.sinau.core.di

import abika.sinau.core.data.source.local.LocalDataSource
import abika.sinau.core.data.source.local.LocalDataSourceImpl
import abika.sinau.core.data.source.local.room.MovieDAO
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * @author by Abika Chairul Yusri on 9/16/2022
 */

//@Module
//@InstallIn(SingletonComponent::class)
//object LocalDataModule {
//
//    @Provides
//    fun provideLocalDataSource(movieDAO: MovieDAO): LocalDataSource {
//        return LocalDataSourceImpl(movieDAO)
//    }
//}