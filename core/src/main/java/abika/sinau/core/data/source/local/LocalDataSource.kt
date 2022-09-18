package abika.sinau.core.data.source.local

import abika.sinau.core.data.source.local.entity.MovieEntity
import kotlinx.coroutines.flow.Flow


/**
 * @author by Abika Chairul Yusri on 9/17/2022
 */
interface LocalDataSource {
    suspend fun saveMovie(movie: List<MovieEntity>)
    fun getAllMovie(): Flow<List<MovieEntity>>
    fun getFavoriteMovies(): Flow<List<MovieEntity>>
    fun updateFavoriteMovie(movie: MovieEntity, newState: Boolean)
}