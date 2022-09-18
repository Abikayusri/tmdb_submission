package abika.sinau.core.utils

import abika.sinau.core.data.source.local.entity.MovieEntity
import abika.sinau.core.data.source.remote.response.MovieResponse
import abika.sinau.core.domain.model.Movie
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf


/**
 * @author by Abika Chairul Yusri on 9/14/2022
 */
object DataMapper {
    fun mapResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()
        input.map {
            val movie = MovieEntity(
                movieId = it.id,
                overview = it.overview,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapResponsesToDomain(input: List<MovieResponse>): Flow<List<Movie>> {
        val movieList = ArrayList<Movie>()

        input.map {
            val movie = Movie(
                movieId = it.id,
                overview = it.overview,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                isFavorite = false
            )
            movieList.add(movie)
        }
        return flowOf(movieList)
    }

    fun mapResponseToDomain(input: MovieResponse): Flow<Movie> {
        return flowOf(
            Movie(
                movieId = input.id,
                overview = input.overview,
                posterPath = input.posterPath,
                releaseDate = input.releaseDate,
                title = input.title,
                isFavorite = false
            )
        )
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                movieId = it.movieId,
                overview = it.overview,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate,
                title = it.title,
                isFavorite = it.isFavorite
            )
        }

    fun mapDomainToEntity(input: Movie) = MovieEntity(
        movieId = input.movieId,
        overview = input.overview,
        posterPath = input.posterPath,
        releaseDate = input.releaseDate,
        title = input.title,
        isFavorite = input.isFavorite
    )
}