package abika.sinau.mymoviedbsubmission.ui.main

import abika.sinau.core.domain.usecase.MovieUseCase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * @author by Abika Chairul Yusri on 9/18/2022
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    movieUseCase: MovieUseCase
): ViewModel() {
    val getMovie = movieUseCase.getAllMovie().asLiveData()
}