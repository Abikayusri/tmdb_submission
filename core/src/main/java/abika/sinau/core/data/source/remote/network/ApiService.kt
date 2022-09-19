package abika.sinau.core.data.source.remote.network

import abika.sinau.core.BuildConfig
import abika.sinau.core.data.source.remote.response.MovieListResponse
import abika.sinau.core.data.source.remote.response.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


/**
 * @author by Abika Chairul Yusri on 9/16/2022
 */
interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = BuildConfig.TOKEN
    ): MovieListResponse

    @GET("search/movie")
    suspend fun getSearchMovie(
        @Query("api_key") apiKey: String = BuildConfig.TOKEN,
        @Query("query") searchQuery: String,
    ): MovieListResponse

    @GET("movie/{movie_id}")
    suspend fun getDetailMovie(
        @Query("api_key") apiKey: String = BuildConfig.TOKEN,
        @Path("movie_id") movieId: String,
    ): MovieResponse
}