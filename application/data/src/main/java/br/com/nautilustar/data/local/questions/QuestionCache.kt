package br.com.nautilustar.data.local.questions

import br.com.nautilustar.data.entity.QuestionEntity
import io.realm.Realm
import java.lang.Exception

class QuestionCache : IQuestion, OutputQuestion, InputQuestion {

    override val input: InputQuestion get() = this
    override val output: OutputQuestion get() = this

    override fun getQuestions(): List<QuestionEntity> {
        val realm = Realm.getDefaultInstance()

        try {
            val query = realm.where(QuestionEntity::class.java)

            if (query.count() > 0) {
                val result = query.findAll()
                if (result != null) {
                    return result
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }

        return emptyList()
    }

    override fun save(questionEntity: QuestionEntity) {
        val realm = Realm.getDefaultInstance()
        try {
            realm.beginTransaction()
            realm.insert(questionEntity)
            realm.commitTransaction()
        } catch (e: Exception) {
            e.printStackTrace()
        } finally {
            realm.close()
        }
    }
}