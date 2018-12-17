package br.com.nautilustar.quizsurvival.features.questions.model

data class TimeQuestion(
    var currentTime: Int = 0,
    val delay: Long = 0,
    val period: Long = 1000
)