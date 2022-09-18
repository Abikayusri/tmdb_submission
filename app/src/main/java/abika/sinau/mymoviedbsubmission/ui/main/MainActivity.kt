package abika.sinau.mymoviedbsubmission.ui.main

import abika.sinau.core.data.Resource
import abika.sinau.core.domain.model.Movie
import abika.sinau.core.ui.MovieAdapter
import abika.sinau.core.utils.gone
import abika.sinau.core.utils.toastShort
import abika.sinau.core.utils.visible
import abika.sinau.mymoviedbsubmission.databinding.ActivityMainBinding
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

// region new

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObserver()
        setupView()
    }

    private fun setupObserver() {
        mainViewModel.getMovie.observe(this@MainActivity) { movie ->
            if (movie != null) {
                when (movie) {
                    is Resource.Loading -> {
                        showProgressBar()
                    }

                    is Resource.Success -> {
                        hideProgressBar()
                        setupRecyclerData(movie.data)

                    }

                    is Resource.Error -> {
                        hideProgressBar()
                    }
                }
            }
        }
    }

    private fun setupView() {

    }

    private fun showProgressBar() {
        binding.pbLoading.visible()
    }

    private fun hideProgressBar() {
        binding.pbLoading.gone()
    }

    private fun setupRecyclerData(data: List<Movie>?) {
        if (!data.isNullOrEmpty()) {
            hideEmptyState()
            binding.apply {
                rvMovie.visible()
                val adapter = MovieAdapter(object : MovieAdapter.OnClickListener {
                    override fun onClickItem(data: Movie) {
                        toastShort("Menekan: ${data.title}")
                    }
                })

                val movieData = ArrayList<Movie>()
                movieData.clear()
                movieData.addAll(data)
                adapter.submitData(movieData)

                rvMovie.adapter = adapter
            }
        } else {
            showEmptyState()
        }
    }

    private fun showEmptyState() {
        binding.inclEmptyState.root.visible()
    }

    private fun hideEmptyState() {
        binding.inclEmptyState.root.gone()
    }
}

// endregion

// region old


//class MainActivity : BaseViewModelActivity<MainViewModel, ActivityMainBinding>() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//    }
//
//    override val viewModelClass: Class<MainViewModel>
//        get() = MainViewModel::class.java
//
//    override fun setupObservers(lifecycleOwner: LifecycleOwner, viewModel: MainViewModel) {
//        viewModel.apply {
//            getMovie.observe(this@MainActivity) { movie ->
//                if (movie != null) {
//                    when (movie) {
//                        is Resource.Loading -> {
//                            toastShort("Loading")
//                            showProgressBar()
//                        }
//
//                        is Resource.Success -> {
//                            toastShort("Success: ${movie.data}")
//                            hideProgressBar()
//                            setupRecyclerData(movie.data)
//
//                        }
//
//                        is Resource.Error -> {
//                            hideProgressBar()
//                            toastShort("Error: ${movie.message}")
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//    private fun showProgressBar() {
//        binding.pbLoading.visible()
//    }
//
//    private fun hideProgressBar() {
//        binding.pbLoading.gone()
//    }
//
//    private fun setupRecyclerData(data: List<Movie>?) {
//        toastShort("setupRecyclerData")
//        if (!data.isNullOrEmpty()) {
//            hideEmptyState()
//            toastShort("setupRecyclerData masuk sini 1")
//            binding.rvMovie.visible()
//            val adapter = MovieAdapter(object : MovieAdapter.OnClickListener {
//                override fun onClickItem(data: Movie) {
//                    toastShort("Menekan: ${data.title}")
//                }
//            })
//
//            val movieData = ArrayList<Movie>()
//            movieData.clear()
//            movieData.addAll(data)
//            adapter.submitData(movieData)
//        } else {
//            toastShort("setupRecyclerData masuk sini 1")
//            showEmptyState()
//        }
//    }
//
//    private fun showEmptyState() {
//        binding.inclEmptyState.root.visible()
//    }
//
//    private fun hideEmptyState() {
//        binding.inclEmptyState.root.gone()
//    }
//
//    override fun setupViews() {
//        binding.inclEmptyState.root.visible()
//    }
//
//    override fun inflateLayout(layoutInflater: LayoutInflater): ActivityMainBinding {
//        return ActivityMainBinding.inflate(layoutInflater)
//    }
//}

// endregion