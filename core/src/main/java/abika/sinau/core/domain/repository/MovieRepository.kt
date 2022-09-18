package abika.sinau.core.domain.repository

import abika.sinau.core.data.Resource
import abika.sinau.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow


/**
 * @author by Abika Chairul Yusri on 9/17/2022
 */
interface MovieRepository {
    fun getAllMovie(): Flow<Resource<List<Movie>>>

    fun getFavoriteMovie(): Flow<List<Movie>>

    fun updateFavoriteMovie(movie: Movie, state: Boolean)

    fun getSearchMovie(searchQuery: String): Flow<Resource<List<Movie>>>

    fun getDetailMovie(movieId: String): Flow<Resource<Movie>>
}