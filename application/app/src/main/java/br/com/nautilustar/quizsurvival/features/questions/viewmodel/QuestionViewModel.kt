package br.com.nautilustar.quizsurvival.features.questions.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.nautilustar.core.base.BaseViewModel
import javax.inject.Inject

interface InputQuestionViewModel {
    fun start()
}

interface OutputQuestionViewModel {
    val show: LiveData<Boolean>
}

interface ContractQuestionViewModel {
    val input: InputQuestionViewModel
    val output: OutputQuestionViewModel
}

class QuestionViewModel @Inject constructor() : BaseViewModel(),
    ContractQuestionViewModel,
    InputQuestionViewModel,
    OutputQuestionViewModel {

    private val showObservable = MutableLiveData<Boolean>()

    override val input: InputQuestionViewModel get() = this
    override val output: OutputQuestionViewModel get() = this

    override val show: LiveData<Boolean> get() = showObservable

    override fun start() {
        showObservable.value = true
    }
}