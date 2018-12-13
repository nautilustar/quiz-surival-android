package br.com.nautilustar.core.di.modules

import androidx.lifecycle.ViewModelProvider
import br.com.nautilustar.core.viewmodel.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class FactoryModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}