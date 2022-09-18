package abika.sinau.core.data.source.remote.response


import com.google.gson.annotations.SerializedName


data class MovieListResponse(
    @SerializedName("results")
    val movieResponses: List<MovieResponse>,
)