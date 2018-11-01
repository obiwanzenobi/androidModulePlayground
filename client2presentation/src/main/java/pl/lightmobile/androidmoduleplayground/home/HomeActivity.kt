package pl.lightmobile.androidmoduleplayground.home

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import pl.lightmobile.androidmoduleplayground.R
import javax.inject.Inject

class HomeActivity : DaggerAppCompatActivity() {

    @Inject lateinit var helloString: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        text.text = helloString
    }
}
