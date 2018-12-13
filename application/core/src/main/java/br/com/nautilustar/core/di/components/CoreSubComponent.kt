package br.com.nautilustar.core.di.components

import br.com.nautilustar.core.di.modules.AndroidModule
import br.com.nautilustar.core.di.modules.FactoryModule
import dagger.Subcomponent

@Subcomponent(modules = [
    AndroidModule::class,
    FactoryModule::class
])
interface CoreSubComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): CoreSubComponent
    }
}