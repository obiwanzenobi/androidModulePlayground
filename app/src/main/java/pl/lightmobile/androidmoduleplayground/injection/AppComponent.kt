package pl.lightmobile.androidmoduleplayground.injection

import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import pl.lightmobile.androidmoduleplayground.App
import pl.lightmobile.androidmoduleplayground.home.HomeBuilder

@AppScope
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        HomeBuilder::class
    ]
)
interface AppComponent : AndroidInjector<App> {
    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()
}
