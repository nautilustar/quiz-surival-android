package br.com.nautilustar.data.di.components

import br.com.nautilustar.data.di.modules.QuestionModule
import dagger.Subcomponent

@Subcomponent(
    modules = [
        QuestionModule::class
    ]
)
interface DataSubComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): DataSubComponent
    }
}