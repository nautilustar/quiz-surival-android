package br.com.nautilustar.data.repository.datasource.cloud

import br.com.nautilustar.data.cloud.responses.QuestionResponse
import br.com.nautilustar.data.local.entity.QuestionEntity
import io.reactivex.Observable

interface IQuestionCloudDataStore {
    fun getQuestions(): Observable<List<QuestionResponse>>
}