package pl.lightmobile.androidmoduleplayground

import dagger.android.support.DaggerApplication
import pl.lightmobile.androidmoduleplayground.injection.DaggerAppComponent

class App : DaggerApplication() {
    override fun applicationInjector() = DaggerAppComponent.builder().create(this)
}
