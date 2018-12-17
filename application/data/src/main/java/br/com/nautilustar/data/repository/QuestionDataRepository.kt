package br.com.nautilustar.data.repository

import br.com.nautilustar.data.cloud.responses.mapper.QuestionCloudMapper
import br.com.nautilustar.data.local.entity.mapper.QuestionLocalMapper
import br.com.nautilustar.data.repository.datasource.cloud.QuestionCloudDataStore
import br.com.nautilustar.data.repository.datasource.local.QuestionLocalLocalDataStore
import br.com.nautilustar.domain.model.QuestionModel
import br.com.nautilustar.domain.repository.QuestionRepository
import io.reactivex.Observable

class QuestionDataRepository(
    private val cloudDataStore: QuestionCloudDataStore,
    private val localDataStore: QuestionLocalLocalDataStore,
    private val cloudMapper: QuestionCloudMapper,
    private val localLocalMapper: QuestionLocalMapper
) : QuestionRepository {

    override fun getQuestions(): Observable<List<QuestionModel>> {
        return if (localDataStore.hasCached()) {
            localDataStore
                .getQuestions()
                .map {
                    it.map { localLocalMapper.transform(it) }
                }
        } else {
            cloudDataStore
                .getQuestions()
                .map {
                    it.map { cloudMapper.transform(it) }
                }
        }
    }
}