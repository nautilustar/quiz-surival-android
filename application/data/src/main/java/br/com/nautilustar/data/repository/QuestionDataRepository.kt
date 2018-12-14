package br.com.nautilustar.data.repository

import br.com.nautilustar.data.entity.mapper.QuestionMapper
import br.com.nautilustar.data.repository.datasource.QuestionLocalDataStore
import br.com.nautilustar.domain.model.QuestionModel
import br.com.nautilustar.domain.repository.QuestionRepository
import io.reactivex.Observable

class QuestionDataRepository(
    private val localDataStore: QuestionLocalDataStore,
    private val mapper: QuestionMapper
) : QuestionRepository {

    override fun getQuestions(): Observable<List<QuestionModel>> {
        return localDataStore
            .getQuestions()
            .map {
                it.map { mapper.transform(it) }
            }
    }
}