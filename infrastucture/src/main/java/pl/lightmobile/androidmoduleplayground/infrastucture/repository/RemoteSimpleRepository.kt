package pl.lightmobile.androidmoduleplayground.infrastucture.repository

import io.reactivex.Single
import pl.lightmobile.androidmoduleplayground.domain.repository.SimpleRepository
import java.util.concurrent.TimeUnit

class RemoteSimpleRepository : SimpleRepository {
    override fun doRemoteOperation(client: String): Single<String> {
        return Single.just("Hello My Remote World connected from $client")
                .delay(10, TimeUnit.SECONDS)
    }
}