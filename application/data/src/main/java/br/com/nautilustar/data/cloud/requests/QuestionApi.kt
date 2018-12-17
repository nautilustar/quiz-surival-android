package br.com.nautilustar.data.cloud.requests

import br.com.nautilustar.data.cloud.responses.QuestionResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface QuestionApi {
    @GET
    fun getQuestions(): Observable<List<QuestionResponse>>
}
