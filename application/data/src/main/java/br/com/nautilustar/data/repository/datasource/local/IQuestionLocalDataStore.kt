package br.com.nautilustar.data.repository.datasource.local

import br.com.nautilustar.data.local.entity.QuestionEntity
import io.reactivex.Observable

interface IQuestionLocalDataStore {
    fun getQuestions(): Observable<List<QuestionEntity>>
    fun hasCached(): Boolean
}