package abika.sinau.core.data.source.remote

import abika.sinau.core.data.source.remote.network.ApiResponse
import abika.sinau.core.data.source.remote.network.ApiService
import abika.sinau.core.data.source.remote.response.MovieListResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @author by Abika Chairul Yusri on 9/16/2022
 */
@Singleton
class RemoteDataSourceImpl @Inject constructor(private val apiService: ApiService) :
    RemoteDataSource {
    override suspend fun getAllMovies(): Flow<ApiResponse<MovieListResponse>> {
        return flow<ApiResponse<MovieListResponse>> {
            val response = apiService.getPopularMovie()
            emit(ApiResponse.Success(response))
        }.flowOn(Dispatchers.IO)
    }

    override suspend fun getSearchMovies(query: String): Flow<ApiResponse<MovieListResponse>> {
        return flow<ApiResponse<MovieListResponse>> {
            val response = apiService.getSearchMovie(searchQuery = query)
            emit(ApiResponse.Success(response))
        }.flowOn(Dispatchers.IO)
    }

}