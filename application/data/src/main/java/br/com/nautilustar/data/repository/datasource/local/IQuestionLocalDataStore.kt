package br.com.nautilustar.data.repository.datasource.local

import br.com.nautilustar.domain.model.QuestionModel
import io.reactivex.Observable

interface IQuestionLocalDataStore {
    fun getQuestions(): Observable<List<QuestionModel>>
    fun hasCached(): Boolean
}