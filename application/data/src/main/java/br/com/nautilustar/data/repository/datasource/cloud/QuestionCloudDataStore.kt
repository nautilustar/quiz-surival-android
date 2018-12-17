package br.com.nautilustar.data.repository.datasource.cloud

import br.com.nautilustar.data.cloud.requests.QuestionApi
import br.com.nautilustar.data.cloud.responses.QuestionResponse
import io.reactivex.Observable

class QuestionCloudDataStore(
    private val questionApi: QuestionApi
) : IQuestionCloudDataStore {

    override fun getQuestions(): Observable<List<QuestionResponse>> {
        return questionApi.getQuestions()
    }
}