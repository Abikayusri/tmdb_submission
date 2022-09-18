package abika.sinau.core.data.source

import abika.sinau.core.data.NetworkBoundResource
import abika.sinau.core.data.Resource
import abika.sinau.core.data.source.local.LocalDataSourceImpl
import abika.sinau.core.data.source.remote.RemoteDataSourceImpl
import abika.sinau.core.data.source.remote.network.ApiResponse
import abika.sinau.core.data.source.remote.response.MovieListResponse
import abika.sinau.core.domain.model.Movie
import abika.sinau.core.domain.repository.MovieRepository
import abika.sinau.core.utils.AppExecutors
import abika.sinau.core.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton


/**
 * @author by Abika Chairul Yusri on 9/17/2022
 */

@Singleton
class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSourceImpl,
    private val localDataSource: LocalDataSourceImpl,
    private val appExecutors: AppExecutors
) : MovieRepository {
    override fun getAllMovie(): Flow<Resource<List<Movie>>> =
        object : NetworkBoundResource<List<Movie>, MovieListResponse>() {
            override fun loadFromDB(): Flow<List<Movie>> {
                return localDataSource.getAllMovie().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Movie>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<MovieListResponse>> {
                return remoteDataSource.getAllMovies()
            }

            override suspend fun saveCallResult(data: MovieListResponse) {
                val responseBody = data.movieResponses
                val movieList = DataMapper.mapResponsesToEntities(responseBody)
                localDataSource.saveMovie(movieList)
            }
        }.asFlow()

    override fun getFavoriteMovie(): Flow<List<Movie>> {
        return localDataSource.getFavoriteMovies().map {
            DataMapper.mapEntitiesToDomain(it)
        }
    }

    override fun updateFavoriteMovie(movie: Movie, state: Boolean) {
        val movieEntity = DataMapper.mapDomainToEntity(movie)
        appExecutors.diskIO().execute { localDataSource.updateFavoriteMovie(movieEntity, state) }
    }
}