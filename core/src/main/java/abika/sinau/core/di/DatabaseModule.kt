package abika.sinau.core.di

import abika.sinau.core.data.source.local.room.MovieDAO
import abika.sinau.core.data.source.local.room.MovieDatabase
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import net.sqlcipher.database.SupportFactory
import net.sqlcipher.database.SQLiteDatabase
import javax.inject.Singleton


/**
 * @author by Abika Chairul Yusri on 9/16/2022
 */

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMovieDatabase(@ApplicationContext context: Context): MovieDatabase {
//    fun provideMovieDatabase(context: Context): MovieDatabase {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("dicoding".toCharArray())
        val factory = SupportFactory(passphrase)
        return Room.databaseBuilder(context, MovieDatabase::class.java, "movie_db")
            .fallbackToDestructiveMigration()
            .openHelperFactory(factory)
            .build()
    }

    @Provides
    fun provideMovieDAO(movieDatabase: MovieDatabase): MovieDAO {
        return movieDatabase.movieDao()
    }
}