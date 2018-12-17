package br.com.nautilustar.data.repository.datasource.cloud

import br.com.nautilustar.data.cloud.requests.QuestionApi
import br.com.nautilustar.data.cloud.responses.mapper.QuestionCloudMapper
import br.com.nautilustar.domain.model.QuestionModel
import io.reactivex.Observable

class QuestionCloudDataStore(
    private val questionApi: QuestionApi,
    private val mapper: QuestionCloudMapper
) : IQuestionCloudDataStore {

    override fun getQuestions(): Observable<List<QuestionModel>> {
        return questionApi.getQuestions()
            .map {
                it.map { mapper.transform(it) }
            }
    }
}