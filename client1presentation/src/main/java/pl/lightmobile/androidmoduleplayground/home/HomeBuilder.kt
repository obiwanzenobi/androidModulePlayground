package pl.lightmobile.androidmoduleplayground.home

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [HomeModule::class, DataModule::class])
abstract class HomeBuilder {
    @ContributesAndroidInjector
    internal abstract fun homeActivity(): HomeActivity
}
