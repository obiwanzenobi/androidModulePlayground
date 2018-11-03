package pl.lightmobile.androidmoduleplayground.home

import android.annotation.SuppressLint
import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.activity_home.*
import pl.lightmobile.androidmoduleplayground.R
import pl.lightmobile.androidmoduleplayground.domain.JustCountDownUseCase
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var helloString: String
    @Inject
    lateinit var countDownUseCase: JustCountDownUseCase

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        text.text = helloString

        the_clicker.setOnClickListener { doSomethingImportant() }

    }

    @SuppressLint("SetTextI18n")
    private fun doSomethingImportant() {
        text.text = "Working... please wait."

        disposables.add(countDownUseCase
                .countDown(10, "I would like to say on the end I was $helloString")
                .delay(1, TimeUnit.SECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { text.text = it },
                        { text.text = "ups, error" }
                ))
    }
}
