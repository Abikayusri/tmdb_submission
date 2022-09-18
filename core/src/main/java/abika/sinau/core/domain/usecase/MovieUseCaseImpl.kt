package abika.sinau.core.domain.usecase

import abika.sinau.core.data.Resource
import abika.sinau.core.domain.model.Movie
import abika.sinau.core.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


/**
 * @author by Abika Chairul Yusri on 9/17/2022
 */
class MovieUseCaseImpl @Inject constructor(
    private val movieRepository: MovieRepository
) : MovieUseCase {

    override fun getAllMovie(): Flow<Resource<List<Movie>>> {
        return movieRepository.getAllMovie()
    }

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return movieRepository.getFavoriteMovie()
    }

    override fun updateFavoriteMovie(movie: Movie, state: Boolean) {
        return movieRepository.updateFavoriteMovie(movie, state)
    }
}