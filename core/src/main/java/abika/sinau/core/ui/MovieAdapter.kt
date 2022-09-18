package abika.sinau.core.ui

import abika.sinau.core.databinding.ItemMovieListBinding
import abika.sinau.core.domain.model.Movie
import abika.sinau.core.utils.Api.BASE_IMAGE_URL_500
import abika.sinau.core.utils.DateUtils
import abika.sinau.core.utils.DateUtils.DD_MMM_YYYY
import abika.sinau.core.utils.DateUtils.YYYY_MM_DD_DASH
import abika.sinau.core.utils.loadImage
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView


/**
 * @author by Abika Chairul Yusri on 9/18/2022
 */

class MovieAdapter(private val onItemClick: OnClickListener) :
    RecyclerView.Adapter<MovieAdapter.MovieAdapterViewHolder>() {

    private val diffCallback = object : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem.movieId == newItem.movieId
        }

        override fun areContentsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem.hashCode() == newItem.hashCode()
        }
    }

    private val differ = AsyncListDiffer(this, diffCallback)

    fun submitData(value: ArrayList<Movie>) = differ.submitList(value)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapterViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MovieAdapterViewHolder(
            ItemMovieListBinding.inflate(inflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MovieAdapterViewHolder, position: Int) {
        val data = differ.currentList[position]
        data.let { holder.bind(data, position) }
    }

    override fun getItemCount(): Int = differ.currentList.size

    inner class MovieAdapterViewHolder(
        private val binding: ItemMovieListBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Movie, position: Int) {
            binding.apply {
                tvTitle.text = data.title
                tvSubtitle.text = data.overview
                ivAvatar.loadImage(BASE_IMAGE_URL_500 + data.posterPath)
                tvReleaseDate.text = DateUtils.convertDateFromTo(data.releaseDate, YYYY_MM_DD_DASH, DD_MMM_YYYY)

                root.setOnClickListener {
                    onItemClick.onClickItem(data)
                }
            }
        }
    }

    interface OnClickListener {
        fun onClickItem(data: Movie)
    }
}
