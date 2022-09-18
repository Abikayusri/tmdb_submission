package abika.sinau.core.di

import abika.sinau.core.data.source.MovieRepositoryImpl
import abika.sinau.core.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * @author by Abika Chairul Yusri on 9/16/2022
 */

@Module(includes = [NetworkModule::class, DatabaseModule::class])
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository
}

//@Module(includes = [NetworkModule::class, DatabaseModule::class])
//@InstallIn(SingletonComponent::class)
//object RepositoryModule {
//
//    @Binds
//    fun provideRepository(movieRepositoryImpl: MovieRepositoryImpl): MovieRepository {
//    }
//}