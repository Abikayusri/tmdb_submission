package abika.sinau.core.data.source.remote

import abika.sinau.core.data.source.remote.network.ApiResponse
import abika.sinau.core.data.source.remote.response.MovieListResponse
import kotlinx.coroutines.flow.Flow


/**
 * @author by Abika Chairul Yusri on 9/16/2022
 */
interface RemoteDataSource {
    suspend fun getAllMovies(): Flow<ApiResponse<MovieListResponse>>
    suspend fun getSearchMovies(query: String): Flow<ApiResponse<MovieListResponse>>
}