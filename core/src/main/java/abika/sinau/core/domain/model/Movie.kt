package abika.sinau.core.domain.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Movie(
    val movieId: Int,
    val overview: String?,
    val posterPath: String?,
    val releaseDate: String?,
    val title: String?,
    val backdropPath: String?,
    var isFavorite: Boolean = false
) : Parcelable