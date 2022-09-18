package abika.sinau.core.data.source.remote.network

import abika.sinau.core.data.source.remote.response.MovieListResponse
import abika.sinau.core.utils.Api.TOKEN
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * @author by Abika Chairul Yusri on 9/16/2022
 */
interface ApiService {

    @GET("movie/popular")
    suspend fun getPopularMovie(
        @Query("api_key") apiKey: String = TOKEN
    ): MovieListResponse

    @GET("search/movie")
    suspend fun getSearchMovie(
        @Query("api_key") apiKey: String = TOKEN,
        @Query("q") searchQuery: String,
    ): MovieListResponse
}