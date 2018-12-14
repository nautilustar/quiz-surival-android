package br.com.nautilustar.domain.repository

import br.com.nautilustar.domain.model.QuestionModel
import io.reactivex.Observable

interface QuestionRepository {
    fun getQuestions(): Observable<List<QuestionModel>>
}