package br.com.nautilustar.data.cloud

import br.com.nautilustar.data.cloud.requests.QuestionApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

@Module
class RequestModule {

    @Provides
    fun provideQuestionApi(retrofit: Retrofit): QuestionApi {
        return retrofit.create(QuestionApi::class.java)
    }
}