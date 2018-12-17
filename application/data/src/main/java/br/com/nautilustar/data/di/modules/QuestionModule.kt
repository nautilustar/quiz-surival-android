package br.com.nautilustar.data.di.modules

import br.com.nautilustar.data.cloud.requests.QuestionApi
import br.com.nautilustar.data.cloud.responses.mapper.QuestionCloudMapper
import br.com.nautilustar.data.local.entity.mapper.QuestionLocalMapper
import br.com.nautilustar.data.local.questions.QuestionCache
import br.com.nautilustar.data.repository.QuestionDataRepository
import br.com.nautilustar.data.repository.datasource.cloud.QuestionCloudDataStore
import br.com.nautilustar.data.repository.datasource.local.QuestionLocalLocalDataStore
import br.com.nautilustar.domain.repository.QuestionRepository
import dagger.Module
import dagger.Provides

@Module
class QuestionModule {

    @Provides
    fun localMapper(): QuestionLocalMapper {
        return QuestionLocalMapper()
    }

    @Provides
    fun cloudMapper(): QuestionCloudMapper {
        return QuestionCloudMapper()
    }

    @Provides
    fun questionCache(): QuestionCache {
        return QuestionCache()
    }

    @Provides
    fun questionCloudDataStore(
        questionApi: QuestionApi,
        mapper: QuestionCloudMapper
    ): QuestionCloudDataStore {
        return QuestionCloudDataStore(questionApi, mapper)
    }

    @Provides
    fun questionLocalDataStore(
        cache: QuestionCache,
        mapper: QuestionLocalMapper
    ): QuestionLocalLocalDataStore {
        return QuestionLocalLocalDataStore(cache, mapper)
    }

    @Provides
    fun questionDataRepository(
        cloud: QuestionCloudDataStore,
        store: QuestionLocalLocalDataStore
    ): QuestionRepository {
        return QuestionDataRepository(cloud, store)
    }
}