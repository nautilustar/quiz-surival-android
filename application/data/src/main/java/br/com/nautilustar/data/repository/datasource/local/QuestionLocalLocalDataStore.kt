package br.com.nautilustar.data.repository.datasource.local

import br.com.nautilustar.data.local.entity.QuestionEntity
import br.com.nautilustar.data.local.entity.mapper.QuestionLocalMapper
import br.com.nautilustar.data.local.questions.QuestionCache
import br.com.nautilustar.domain.model.QuestionModel
import io.reactivex.Observable

class QuestionLocalLocalDataStore(
    private val cache: QuestionCache,
    private val mapper: QuestionLocalMapper
) : IQuestionLocalDataStore {

    override fun getQuestions(): Observable<List<QuestionModel>> {
        return Observable.just(mocksQuestion())
            .map {
                it.map { mapper.transform(it) }
            }
    }

    private fun mocksQuestion(): List<QuestionEntity> {
        val list: ArrayList<QuestionEntity> = arrayListOf()

        (0..10).forEach {
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