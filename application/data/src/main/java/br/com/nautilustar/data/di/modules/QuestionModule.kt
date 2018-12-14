package br.com.nautilustar.data.di.modules

import br.com.nautilustar.data.entity.mapper.QuestionMapper
import br.com.nautilustar.data.local.questions.QuestionCache
import br.com.nautilustar.data.repository.QuestionDataRepository
import br.com.nautilustar.data.repository.datasource.QuestionLocalDataStore
import br.com.nautilustar.domain.repository.QuestionRepository
import dagger.Module
import dagger.Provides

@Module
class QuestionModule {

    @Provides
    fun provideSettingsMapper(): QuestionMapper {
        return QuestionMapper()
    }

    @Provides
    fun provideSettingsCache(): QuestionCache {
        return QuestionCache()
    }

    @Provides
    fun provideSettingsLocalDataStore(cache: QuestionCache): QuestionLocalDataStore {
        return QuestionLocalDataStore(cache)
    }

    @Provides
    fun provideSettingsDataRepository(store: QuestionLocalDataStore, mapper: QuestionMapper): QuestionRepository {
        return QuestionDataRepository(store, mapper)
    }
}