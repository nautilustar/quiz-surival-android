package br.com.nautilustar.data.repository.datasource

import br.com.nautilustar.data.entity.QuestionEntity
import io.reactivex.Observable

interface IQuestionDataStore {
    fun getQuestions() : Observable<List<QuestionEntity>>
}