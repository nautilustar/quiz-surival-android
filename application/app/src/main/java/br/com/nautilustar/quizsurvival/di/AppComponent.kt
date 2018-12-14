package br.com.nautilustar.quizsurvival.di

import android.app.Application
import br.com.nautilustar.core.di.modules.AndroidModule
import br.com.nautilustar.core.di.modules.FactoryModule
import br.com.nautilustar.data.di.modules.QuestionModule
import br.com.nautilustar.quizsurvival.AndroidApplication
import br.com.nautilustar.quizsurvival.di.modules.ActivityModule
import br.com.nautilustar.quizsurvival.di.modules.FragmentModule
import br.com.nautilustar.quizsurvival.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        FactoryModule::class,
        AndroidModule::class,
        ActivityModule::class,
        FragmentModule::class,
        ViewModelModule::class,
        QuestionModule::class
    ]
)
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: AndroidApplication)
}