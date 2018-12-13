package br.com.nautilustar.quizsurvival.di.modules

import androidx.lifecycle.ViewModel
import br.com.nautilustar.core.viewmodel.ViewModelKey
import br.com.nautilustar.quizsurvival.features.questions.viewmodel.QuestionViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(QuestionViewModel::class)
    abstract fun questionViewModel(viewModel: QuestionViewModel): ViewModel
}