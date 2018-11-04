package pl.lightmobile.androidmoduleplayground.domain

import io.reactivex.Single
import pl.lightmobile.androidmoduleplayground.domain.repository.SimpleRepository

class DoRemoteOperationUseCase constructor(private val repository: SimpleRepository) {
    fun doImportantThing(client: String): Single<String> = repository.doRemoteOperation(client)
}