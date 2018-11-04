package pl.lightmobile.androidmoduleplayground.home

import dagger.Module
import dagger.Provides
import pl.lightmobile.androidmoduleplayground.domain.DoRemoteOperationUseCase
import pl.lightmobile.androidmoduleplayground.domain.repository.SimpleRepository

@Module
class HomeModule {

    @Provides
    fun provideHello(): String = "client1"

    @Provides
    fun provideDoRemoteOperationUseCase(repository: SimpleRepository): DoRemoteOperationUseCase =
            DoRemoteOperationUseCase(repository)
}
