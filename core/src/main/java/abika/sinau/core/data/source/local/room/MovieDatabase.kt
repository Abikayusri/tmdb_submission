package abika.sinau.core.data.source.local.room

import abika.sinau.core.data.source.local.entity.MovieEntity
import androidx.room.Database
import androidx.room.RoomDatabase


/**
 * @author by Abika Chairul Yusri on 9/16/2022
 */

@Database(
    entities = [MovieEntity::class],
    version = 1,
    exportSchema = false
)


abstract class MovieDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDAO
}