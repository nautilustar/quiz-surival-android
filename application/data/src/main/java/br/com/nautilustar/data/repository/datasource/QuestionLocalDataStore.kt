package br.com.nautilustar.data.repository.datasource

import br.com.nautilustar.data.entity.QuestionEntity
import br.com.nautilustar.data.local.questions.QuestionCache
import io.reactivex.Observable

class QuestionLocalDataStore(
    private val cache: QuestionCache
) : IQuestionDataStore {

    override fun getQuestions(): Observable<List<QuestionEntity>> {
        return Observable.just(cache.output.getQuestions())
    }
}