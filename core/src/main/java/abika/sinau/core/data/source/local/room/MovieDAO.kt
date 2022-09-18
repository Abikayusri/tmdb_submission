package abika.sinau.core.data.source.local.room

import abika.sinau.core.data.source.local.entity.MovieEntity
import androidx.room.*
import kotlinx.coroutines.flow.Flow


/**
 * @author by Abika Chairul Yusri on 9/16/2022
 */

@Dao
interface MovieDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movie: List<MovieEntity>)

    @Query("SELECT * FROM popular_movies where isFavorite = 1")
    fun getFavoriteMovies(): Flow<List<MovieEntity>>

    @Query("SELECT * FROM popular_movies")
    fun getAllMovie(): Flow<List<MovieEntity>>

    @Update
    fun updateFavoriteMovie(movie: MovieEntity)
}