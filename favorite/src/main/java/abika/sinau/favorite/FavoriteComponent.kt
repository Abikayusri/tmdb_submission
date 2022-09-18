package abika.sinau.favorite

import abika.sinau.mymoviedbsubmission.di.FavoriteModuleDependencies
import android.content.Context
import dagger.BindsInstance
import dagger.Component


/**
 * @author by Abika Chairul Yusri on 9/19/2022
 */

@Component(dependencies = [FavoriteModuleDependencies::class])
interface FavoriteComponent {

    fun inject(activity: FavoriteActivity)

    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(favoriteModuleDependencies: FavoriteModuleDependencies): Builder
        fun build(): FavoriteComponent
    }
}