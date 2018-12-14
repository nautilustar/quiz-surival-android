package br.com.engcad.data.di.components

import br.com.engcad.data.di.modules.SettingsModule
import dagger.Subcomponent

@Subcomponent(modules = [
    SettingsModule::class
])
interface DataSubComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): DataSubComponent
    }
}