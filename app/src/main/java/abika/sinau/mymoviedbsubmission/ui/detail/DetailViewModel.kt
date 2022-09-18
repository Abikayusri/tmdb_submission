package abika.sinau.mymoviedbsubmission.ui.detail

import abika.sinau.core.domain.model.Movie
import abika.sinau.core.domain.usecase.MovieUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * @author by Abika Chairul Yusri on 9/18/2022
 */

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {
    fun getDetailMovie(movieId: String) = movieUseCase.getDetailMovie(movieId).asLiveData()
    fun updateFavoriteMovie(movie: Movie, newStatus: Boolean) =
        movieUseCase.updateFavoriteMovie(movie, newStatus)
}