package abika.sinau.favorite

import abika.sinau.core.domain.model.Movie
import abika.sinau.core.ui.MovieAdapter
import abika.sinau.core.utils.gone
import abika.sinau.core.utils.toastShort
import abika.sinau.core.utils.visible
import abika.sinau.favorite.databinding.ActivityFavoriteBinding
import abika.sinau.mymoviedbsubmission.di.FavoriteModuleDependencies
import abika.sinau.mymoviedbsubmission.ui.detail.DetailActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.EntryPointAccessors
import javax.inject.Inject

class FavoriteActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: ViewModelFactory

    private lateinit var binding: ActivityFavoriteBinding

    private val viewModel: FavoriteViewModel by viewModels {
        factory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerFavoriteComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    FavoriteModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)

        super.onCreate(savedInstanceState)

        binding = ActivityFavoriteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupObserver()
    }

    private fun setupObserver() {
        viewModel.resulFavorite.observe(this@FavoriteActivity) { movie ->
            if (!movie.isNullOrEmpty()) {
                hideEmptyState()
                setupData(movie)
            } else {
                showEmptyState()
            }
        }
    }

    private fun setupData(data: List<Movie>) {
        val adapter = MovieAdapter(object : MovieAdapter.OnClickListener {
            override fun onClickItem(data: Movie) {
                DetailActivity.newInstance(this@FavoriteActivity, data)
            }
        })

        val movieData = ArrayList<Movie>()
        movieData.clear()
        movieData.addAll(data)
        adapter.submitData(movieData)

        binding.rvFavorite.adapter = adapter
        binding.rvFavorite.visible()
    }

    private fun hideEmptyState() {
        binding.incEmptyState.root.gone()
    }

    private fun showEmptyState() {
        binding.incEmptyState.root.visible()
    }
}