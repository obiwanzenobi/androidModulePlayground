package pl.lightmobile.androidmoduleplayground.home

import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @Provides
    fun provideHello(): String = "client2"
}
