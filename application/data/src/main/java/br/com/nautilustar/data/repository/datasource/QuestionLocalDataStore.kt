package br.com.nautilustar.data.repository.datasource

import br.com.nautilustar.data.entity.QuestionEntity
import br.com.nautilustar.data.local.questions.QuestionCache
import br.com.nautilustar.domain.model.QuestionModel
import io.reactivex.Observable

class QuestionLocalDataStore(
    private val cache: QuestionCache
) : IQuestionDataStore {

    override fun getQuestions(): Observable<List<QuestionEntity>> {
        //return Observable.just(cache.output.getQuestions())
        return Observable.just(mocksQuestion())
    }

    private fun mocksQuestion(): List<QuestionEntity> {
        val list: ArrayList<QuestionEntity> = arrayListOf()

        (1..6).forEach {
            list.add(QuestionEntity().apply {
                question = "Qual é o meu nome do $it º jogador?"
                a = "Alternativa A"
                b = "Alternativa B"
                c = "Alternativa C"
                d = "Alternativa D"
                answer = "A"
            })
        }

        return list
    }
}