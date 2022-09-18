package abika.sinau.core.domain.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val movieId: Int,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    var isFavorite: Boolean = false
) : Parcelable