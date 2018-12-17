package br.com.nautilustar.quizsurvival.features.questions.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.nautilustar.core.base.BaseViewModel
import br.com.nautilustar.domain.DefaultObserver
import br.com.nautilustar.domain.interactor.GetQuestion
import br.com.nautilustar.domain.model.QuestionModel
import br.com.nautilustar.quizsurvival.features.questions.model.TimeQuestion
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

interface InputQuestionViewModel {
    fun start()
    fun next()
}

interface OutputQuestionViewModel {
    val configure: LiveData<Boolean>
    val start: LiveData<Boolean>
    val showQuestion: LiveData<QuestionModel>
    val progress: LiveData<Int>
    val finish: LiveData<Boolean>
}

interface ContractQuestionViewModel {
    val input: InputQuestionViewModel
    val output: OutputQuestionViewModel
}

@Singleton
class QuestionViewModel @Inject constructor(
    private val getQuestion: GetQuestion
) : BaseViewModel(),
    ContractQuestionViewModel,
    InputQuestionViewModel,
    OutputQuestionViewModel {

    private lateinit var questions: List<QuestionModel>
    private val iterator by lazy { questions.listIterator() }
    private val timer by lazy { Timer() }
    private val timeQuestion by lazy { TimeQuestion() }

    private val showQuestionObservable = MutableLiveData<QuestionModel>()
    private val configureObservable = MutableLiveData<Boolean>()
    private val progressObservable = MutableLiveData<Int>()
    private val startObservable = MutableLiveData<Boolean>()
    private val finishObservable = MutableLiveData<Boolean>()

    override val input: InputQuestionViewModel get() = this
    override val output: OutputQuestionViewModel get() = this

    override val showQuestion: LiveData<QuestionModel> get() = showQuestionObservable
    override val configure: LiveData<Boolean> get() = configureObservable
    override val start: LiveData<Boolean> get() = startObservable
    override val progress: LiveData<Int> get() = progressObservable
    override val finish: LiveData<Boolean> get() = finishObservable

    override fun start() {
        getQuestion.execute(object : DefaultObserver<List<QuestionModel>>() {
            override fun onNext(t: List<QuestionModel>) {
                super.onNext(t)
                questions = t
                configureObservable.postValue(true)
                configTimer()
            }

            override fun onError(exception: Throwable) {
                super.onError(exception)
                configureObservable.postValue(false)
            }
        })
    }

    override fun next() {
        if (iterator.hasNext()) {
            val question = iterator.next()
            showQuestionObservable.value = question
        }
    }

    private fun configTimer() {
        timer.schedule(object : TimerTask() {
            override fun run() {
                progressObservable.postValue(timeQuestion.currentTime++)
                verifyFinishGame()
            }
        }, timeQuestion.delay, timeQuestion.period)
    }

    private fun verifyFinishGame() {
        if (timeQuestion.currentTime == 60) {
            finishObservable.postValue(true)
        }
    }
}