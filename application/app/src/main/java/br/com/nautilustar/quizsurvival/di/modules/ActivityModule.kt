package br.com.nautilustar.quizsurvival.di.modules

import br.com.engcad.entrance.di.modules.FragmentModule
import br.com.nautilustar.quizsurvival.features.questions.actvities.QuestionActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun questionActivity(): QuestionActivity
}