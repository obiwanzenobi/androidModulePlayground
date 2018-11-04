package pl.lightmobile.androidmoduleplayground.domain.repository

import io.reactivex.Single

interface SimpleRepository {
    fun doRemoteOperation(client: String): Single<String>
}