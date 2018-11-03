package pl.lightmobile.androidmoduleplayground.domain

import dagger.Reusable
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import java.util.concurrent.TimeUnit
import javax.inject.Inject

const val APP_NAME = "AndroidModulePlayground"

@Reusable
class JustCountDownUseCase @Inject constructor() {

    fun countDown(timeout: Int, sayOnFinish: String): Observable<String> =
            Observable.zip(
                    Observable.range(0, timeout + 1),
                    Observable.interval(1, TimeUnit.SECONDS),
                    BiFunction<Int, Long, String> { t1, _ ->
                        var left = timeout - t1
                        if (left > 0) (timeout - t1).toString()
                        else sayOnFinish
                    })
}