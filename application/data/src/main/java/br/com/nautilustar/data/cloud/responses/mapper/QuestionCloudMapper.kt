package br.com.nautilustar.data.cloud.responses.mapper

import br.com.nautilustar.data.cloud.responses.QuestionResponse
import br.com.nautilustar.data.repository.Mapper
import br.com.nautilustar.domain.model.QuestionModel

class QuestionCloudMapper : Mapper<QuestionResponse, QuestionModel> {

    override fun transform(entity: QuestionResponse): QuestionModel {
        return QuestionModel(
            question = entity.question,
            a = entity.a,
            b = entity.b,
            c = entity.c,
            d = entity.d,
            answer = entity.answer
        )
    }
}