package abika.sinau.core.data.source.local

import abika.sinau.core.data.source.local.entity.MovieEntity
import abika.sinau.core.data.source.local.room.MovieDAO
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @author by Abika Chairul Yusri on 9/17/2022
 */
@Singleton
class LocalDataSourceImpl @Inject constructor(
    private val movieDAO: MovieDAO
): LocalDataSource {
    override suspend fun saveMovie(movie: List<MovieEntity>) {
        return movieDAO.saveMovie(movie)
    }

    override fun getAllMovie(): Flow<List<MovieEntity>> {
        return movieDAO.getAllMovie()
    }

    override fun getFavoriteMovies(): Flow<List<MovieEntity>> {
        return movieDAO.getFavoriteMovies()
    }

    override fun updateFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        movieDAO.updateFavoriteMovie(movie)
    }

}