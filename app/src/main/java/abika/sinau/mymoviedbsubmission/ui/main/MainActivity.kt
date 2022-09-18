package abika.sinau.mymoviedbsubmission.ui.main

import abika.sinau.core.R
import abika.sinau.core.data.Resource
import abika.sinau.core.domain.model.Movie
import abika.sinau.core.ui.MovieAdapter
import abika.sinau.core.utils.gone
import abika.sinau.core.utils.toastShort
import abika.sinau.core.utils.visible
import abika.sinau.mymoviedbsubmission.databinding.ActivityMainBinding
import android.os.Bundle
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
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
        setupMovie()
        setupSearch()
    }

    private fun setupSearch() {
        mainViewModel.resultSearch.observe(this@MainActivity) { movie ->
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

    private fun setupView() {
        setSearchView()
    }

    private fun setSearchView() {
        binding.svMovie.apply {
            setOnQueryTextListener(
                object : SearchView.OnQueryTextListener {
                    override fun onQueryTextSubmit(searchQuery: String?): Boolean {
                        if (searchQuery?.isNotEmpty() == true) {
                            mainViewModel.setSearchQuery(searchQuery.toString())
                        } else {
                            setupMovie()
                        }
                        return false
                    }

                    override fun onQueryTextChange(searchQuery: String?): Boolean {
                        if (searchQuery?.isEmpty() == true) setupMovie()
                        return false
                    }
                }
            )

            setOnCloseListener {
                setupMovie()
                false
            }
        }

        val searchEditText =
            binding.svMovie.findViewById<EditText>(androidx.appcompat.R.id.search_src_text)
        searchEditText.setHintTextColor(resources.getColor(R.color.gray))
        searchEditText.setTextColor(resources.getColor(R.color.black))
    }

    private fun setupMovie() {
        mainViewModel.getAllMovies().observe(this@MainActivity, movieObserver)
    }

    private val movieObserver = Observer<Resource<List<Movie>>> { movie ->
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