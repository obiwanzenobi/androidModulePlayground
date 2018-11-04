package pl.lightmobile.androidmoduleplayground.home

import dagger.Module
import dagger.Provides
import pl.lightmobile.androidmoduleplayground.domain.repository.SimpleRepository
import pl.lightmobile.androidmoduleplayground.infrastucture.repository.RemoteSimpleRepository

@Module
class DataModule {
    @Provides
    fun provideSimpleRepository(): SimpleRepository = RemoteSimpleRepository()
}
