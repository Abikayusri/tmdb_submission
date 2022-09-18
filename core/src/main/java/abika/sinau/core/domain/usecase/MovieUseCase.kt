package abika.sinau.core.domain.usecase

import abika.sinau.core.data.Resource
import abika.sinau.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow


/**
 * @author by Abika Chairul Yusri on 9/17/2022
 */
interface MovieUseCase {
    fun getAllMovie(): Flow<Resource<List<Movie>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun updateFavoriteMovie(movie: Movie, state:Boolean)
}