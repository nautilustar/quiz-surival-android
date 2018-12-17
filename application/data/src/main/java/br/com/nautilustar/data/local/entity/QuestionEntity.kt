package br.com.nautilustar.data.local.entity

import io.realm.RealmObject

open class QuestionEntity : RealmObject() {
    lateinit var question: String
    lateinit var a: String
    lateinit var b: String
    lateinit var c: String
    lateinit var d: String
    lateinit var answer: String
}