package br.com.engcad.entrance.di.modules

import androidx.lifecycle.ViewModel
import br.com.engcad.core.di.components.CoreSubComponent
import br.com.engcad.core.viewmodel.ViewModelKey
import br.com.engcad.entrance.viewmodel.EntranceViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module(subcomponents = [CoreSubComponent::class])
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(EntranceViewModel::class)
    abstract fun bindEntranceViewModel(viewModel: EntranceViewModel): ViewModel
}