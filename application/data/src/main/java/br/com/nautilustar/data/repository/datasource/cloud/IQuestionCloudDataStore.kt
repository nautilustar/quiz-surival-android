package br.com.nautilustar.data.repository.datasource.cloud

import br.com.nautilustar.domain.model.QuestionModel
import io.reactivex.Observable

interface IQuestionCloudDataStore {
    fun getQuestions(): Observable<List<QuestionModel>>
}