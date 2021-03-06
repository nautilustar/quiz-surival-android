package br.com.nautilustar.quizsurvival.di.modules

import br.com.nautilustar.quizsurvival.features.questions.screens.QuestionActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule {

    @ContributesAndroidInjector(modules = [FragmentModule::class])
    abstract fun questionActivity(): QuestionActivity
}