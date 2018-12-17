package br.com.nautilustar.data.local.entity.mapper

import br.com.nautilustar.data.local.entity.QuestionEntity
import br.com.nautilustar.data.repository.Mapper
import br.com.nautilustar.domain.model.QuestionModel

class QuestionLocalMapper : Mapper<QuestionEntity, QuestionModel> {

    override fun transform(entity: QuestionEntity): QuestionModel {
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