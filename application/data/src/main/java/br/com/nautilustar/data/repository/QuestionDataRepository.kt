package br.com.nautilustar.data.repository

import br.com.nautilustar.data.repository.datasource.cloud.QuestionCloudDataStore
import br.com.nautilustar.data.repository.datasource.local.QuestionLocalLocalDataStore
import br.com.nautilustar.domain.model.QuestionModel
import br.com.nautilustar.domain.repository.QuestionRepository
import io.reactivex.Observable

class QuestionDataRepository(
    private val cloudDataStore: QuestionCloudDataStore,
    private val localDataStore: QuestionLocalLocalDataStore
) : QuestionRepository {

    override fun getQuestions(): Observable<List<QuestionModel>> {
        return if (localDataStore.hasCached()) {
            localDataStore.getQuestions()
        } else {
            cloudDataStore.getQuestions()
        }
    }
}