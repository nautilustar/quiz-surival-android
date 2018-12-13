package br.com.nautilustar.quizsurvival.di.modules

import br.com.nautilustar.quizsurvival.features.questions.fragments.QuestionFragment
import br.com.nautilustar.quizsurvival.features.questions.fragments.QuestionResultFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun questionFragment(): QuestionFragment

    @ContributesAndroidInjector
    abstract fun questionResultFragment(): QuestionResultFragment
}