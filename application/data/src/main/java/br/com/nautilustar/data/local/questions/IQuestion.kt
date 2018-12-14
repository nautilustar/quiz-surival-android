package br.com.nautilustar.data.local.questions

import br.com.nautilustar.data.entity.QuestionEntity

interface InputQuestion {
    fun save(questionEntity: QuestionEntity)
}

interface OutputQuestion {
    fun getQuestions(): List<QuestionEntity>
}

interface IQuestion {
    val input: InputQuestion
    val output: OutputQuestion
}