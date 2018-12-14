package br.com.nautilustar.data.entity.mapper

import br.com.engcad.data.model.mapper.Mapper
import br.com.nautilustar.data.entity.QuestionEntity
import br.com.nautilustar.domain.model.QuestionModel

class QuestionMapper : Mapper<QuestionEntity, QuestionModel> {

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