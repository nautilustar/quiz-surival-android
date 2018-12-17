package br.com.nautilustar.data.cloud.responses

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class QuestionResponse(
    @SerializedName("question") var question: String,
    @SerializedName("A") var a: String,
    @SerializedName("B") var b: String,
    @SerializedName("C") var c: String,
    @SerializedName("D") var d: String,
    @SerializedName("answer") var answer: String
) : Serializable