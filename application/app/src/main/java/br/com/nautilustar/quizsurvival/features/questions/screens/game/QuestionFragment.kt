package br.com.nautilustar.quizsurvival.features.questions.screens.game

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import br.com.nautilustar.core.base.BaseFragment
import br.com.nautilustar.quizsurvival.R
import br.com.nautilustar.quizsurvival.databinding.FragmentQuestionBinding
import br.com.nautilustar.quizsurvival.features.questions.viewmodel.QuestionViewModel

class QuestionFragment
    : BaseFragment<FragmentQuestionBinding, QuestionViewModel>(), QuestionListener {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewObserver()
        observerViewModel()
        initGame()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_question
    }

    override fun getViewModel(): QuestionViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(QuestionViewModel::class.java)
    }

    override fun onNextClick(v: View?) {
        clearChoice()
        getViewModel().input.next()
    }

    private fun bindViewObserver() {
        getViewDataBinding().handlers = this
    }

    private fun observerViewModel() {
        getViewModel().output.run {
            showQuestion.observe(this@QuestionFragment, Observer {
                getViewDataBinding().questionModel = it
            })

            progress.observe(this@QuestionFragment, Observer {
                getViewDataBinding().progress = it
            })

            finish.observe(this@QuestionFragment, Observer {
                if (it) showResult()
            })
        }
    }

    private fun initGame() {
        getViewModel().input.next()
    }

    private fun showResult() {
        findNavController().navigate(R.id.action_questionFragment_to_questionResultFragment)
    }

    private fun clearChoice() {
        getViewDataBinding().radioGroup.clearCheck()
    }
}

interface QuestionListener {
    fun onNextClick(v: View?)
}