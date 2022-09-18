package abika.sinau.mymoviedbsubmission.di

import abika.sinau.core.domain.usecase.MovieUseCase
import abika.sinau.core.domain.usecase.MovieUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * @author by Abika Chairul Yusri on 9/18/2022
 */

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    abstract fun provideMovieUseCase(movieUseCaseImpl: MovieUseCaseImpl): MovieUseCase
}