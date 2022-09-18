package abika.sinau.mymoviedbsubmission.ui.main

import abika.sinau.core.data.Resource
import abika.sinau.core.domain.model.Movie
import abika.sinau.core.domain.usecase.MovieUseCase
import androidx.lifecycle.*
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


/**
 * @author by Abika Chairul Yusri on 9/18/2022
 */

@HiltViewModel
class MainViewModel @Inject constructor(
    private val movieUseCase: MovieUseCase
) : ViewModel() {

    fun getAllMovies(): LiveData<Resource<List<Movie>>> {
        return movieUseCase.getAllMovie().asLiveData()
    }

    private var username: MutableLiveData<String> = MutableLiveData()

    fun setSearchQuery(search: String) {
        username.value = search
    }

    val resultSearch: LiveData<Resource<List<Movie>>> = Transformations.switchMap(username) {
        movieUseCase.getSearchMovie(it).asLiveData()
    }
}