package pl.lightmobile.androidmoduleplayground.home

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_home.*
import pl.lightmobile.androidmoduleplayground.R
import pl.lightmobile.androidmoduleplayground.domain.DoRemoteOperationUseCase
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var helloString: String

    @Inject
    lateinit var remoteOperation: DoRemoteOperationUseCase

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        text.text = helloString
        remote_button_action.setOnClickListener { doSomethinRemote() }
    }

    private fun doSomethinRemote() {
        text.text = "Request was sent..."

        disposables.add(remoteOperation
                .doImportantThing(helloString)
                .delay(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { text.text = it },
                        { text.text = "ups, error" }
                ))
    }
}
