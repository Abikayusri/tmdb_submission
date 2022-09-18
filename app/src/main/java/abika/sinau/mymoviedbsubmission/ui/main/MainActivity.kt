package abika.sinau.mymoviedbsubmission.ui.main

import abika.sinau.core.data.Resource
import abika.sinau.core.utils.base.BaseViewModelActivity
import abika.sinau.core.utils.toastShort
import abika.sinau.mymoviedbsubmission.R
import abika.sinau.mymoviedbsubmission.databinding.ActivityMainBinding
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.LifecycleOwner
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseViewModelActivity<MainViewModel, ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override val viewModelClass: Class<MainViewModel>
        get() = MainViewModel::class.java

    override fun setupObservers(lifecycleOwner: LifecycleOwner, viewModel: MainViewModel) {
        viewModel.apply {
            getMovie.observe(this@MainActivity) { movie ->
                if (movie != null) {
                    when (movie) {
                        is Resource.Loading -> {
                            toastShort("Loading")
                        }

                        is Resource.Success -> {
                            toastShort("Success: ${movie.data}")

                        }

                        is Resource.Error -> {
                            toastShort("Error: ${movie.message}")
                        }
                    }
                }
            }
        }
    }

    override fun setupViews() {

    }

    override fun inflateLayout(layoutInflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}