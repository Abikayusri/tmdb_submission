package abika.sinau.mymoviedbsubmission.ui.detail

import abika.sinau.core.R
import abika.sinau.core.domain.model.Movie
import abika.sinau.core.utils.Api.BASE_IMAGE_URL
import abika.sinau.core.utils.Api.BASE_IMAGE_URL_500
import abika.sinau.core.utils.DateUtils
import abika.sinau.core.utils.loadImage
import abika.sinau.mymoviedbsubmission.databinding.ActivityDetailBinding
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private val viewModel: DetailViewModel by viewModels()

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA)
        showDetailMovie(detailMovie)

        setupObserver()
        setupView()
    }

    private fun showDetailMovie(data: Movie?) {
        binding.apply {
            tvTitle.text = data?.title
            tvReleaseDate.text = DateUtils.convertDateFromTo(data?.releaseDate,
                DateUtils.YYYY_MM_DD_DASH,
                DateUtils.DD_MMM_YYYY
            )
            tvOverview.text = data?.overview

            ivBackdrop.loadImage(BASE_IMAGE_URL_500 + data?.backdropPath)
            ivPoster.loadImage(BASE_IMAGE_URL + data?.posterPath)

            var statusFavorite = data?.isFavorite
            updateFavorite(statusFavorite)
            fabFavorite.setOnClickListener {
                statusFavorite = !statusFavorite!!
                if (data != null) {
                    viewModel.updateFavoriteMovie(movie = data, newStatus = statusFavorite!!)
                    updateFavorite(statusFavorite)
                }
            }
        }
    }

    private fun updateFavorite(statusFavorite: Boolean?) {
        if (statusFavorite == true) {
            binding.fabFavorite.setImageResource(R.drawable.ic_favorite_red_24dp)
        } else {
            binding.fabFavorite.setImageResource(R.drawable.ic_favorite_white_24dp)
        }
    }

    private fun setupView() {

    }

    private fun setupObserver() {

    }

    companion object {
        const val EXTRA_DATA = "EXTRA_DATA"

        fun newInstance(context: Context, movie: Movie) {
            context.startActivity(
                Intent(context, DetailActivity::class.java).run {
                    putExtra(EXTRA_DATA, movie)
                }
            )
        }
    }
}