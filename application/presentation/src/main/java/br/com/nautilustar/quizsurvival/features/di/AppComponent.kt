package br.com.nautilustar.quizsurvival.features.di

import android.app.Application
import br.com.nautilustar.core.di.modules.AndroidModule
import br.com.nautilustar.core.di.modules.FactoryModule
import br.com.nautilustar.quizsurvival.features.AndroidApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    FactoryModule::class,
    AndroidModule::class
])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AndroidApplication)
}