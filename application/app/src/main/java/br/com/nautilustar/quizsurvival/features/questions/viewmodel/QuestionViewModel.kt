package br.com.nautilustar.quizsurvival.features.questions.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.nautilustar.core.base.BaseViewModel
import br.com.nautilustar.domain.DefaultObserver
import br.com.nautilustar.domain.interactor.GetQuestion
import br.com.nautilustar.domain.model.QuestionModel
import br.com.nautilustar.quizsurvival.features.questions.model.Question
import javax.inject.Inject

interface InputQuestionViewModel {
    fun start()
    fun next()
}

interface OutputQuestionViewModel {
    val showQuestion: LiveData<QuestionModel>
}

interface ContractQuestionViewModel {
    val input: InputQuestionViewModel
    val output: OutputQuestionViewModel
}

class QuestionViewModel @Inject constructor(
    private val getQuestion: GetQuestion
) : BaseViewModel(),
    ContractQuestionViewModel,
    InputQuestionViewModel,
    OutputQuestionViewModel {

    private lateinit var questions: List<QuestionModel>
    private val iterator by lazy { questions.listIterator() }
    private val showQuestionObservable = MutableLiveData<QuestionModel>()

    override val input: InputQuestionViewModel get() = this
    override val output: OutputQuestionViewModel get() = this

    override val showQuestion: LiveData<QuestionModel> get() = showQuestionObservable

    override fun start() {
        getQuestion.execute(object : DefaultObserver<List<QuestionModel>>() {
            override fun onNext(t: List<QuestionModel>) {
                super.onNext(t)
                questions = t
            }

            override fun onError(exception: Throwable) {
                super.onError(exception)
            }
        })
    }

    override fun next() {
        if(iterator.hasNext()) {
            val question = iterator.next()
            showQuestionObservable.value = question
        }
    }
}