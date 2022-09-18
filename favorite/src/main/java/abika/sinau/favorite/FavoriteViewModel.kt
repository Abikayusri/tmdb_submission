package abika.sinau.favorite

import abika.sinau.core.domain.usecase.MovieUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * @author by Abika Chairul Yusri on 9/19/2022
 */


class FavoriteViewModel (movieUseCase: MovieUseCase): ViewModel() {
    val resulFavorite = movieUseCase.getFavoriteMovie().asLiveData()
}