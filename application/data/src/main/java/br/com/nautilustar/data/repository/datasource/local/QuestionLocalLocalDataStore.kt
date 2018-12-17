package br.com.nautilustar.data.repository.datasource.local

import br.com.nautilustar.data.local.entity.QuestionEntity
import br.com.nautilustar.data.local.questions.QuestionCache
import io.reactivex.Observable

class QuestionLocalLocalDataStore(
    private val cache: QuestionCache
) : IQuestionLocalDataStore {

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

    override fun hasCached(): Boolean {
        return cache.hasCache()
    }
}