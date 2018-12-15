package br.com.nautilustar.quizsurvival.features.questions.screens.game

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import br.com.nautilustar.core.base.BaseFragment
import br.com.nautilustar.quizsurvival.R
import br.com.nautilustar.quizsurvival.databinding.FragmentQuestionStartBinding
import br.com.nautilustar.quizsurvival.features.questions.viewmodel.QuestionViewModel

class QuestionStartFragment : BaseFragment<FragmentQuestionStartBinding, QuestionViewModel>() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindViewObserver()
        bindViewModel()
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_question_start
    }

    override fun getViewModel(): QuestionViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(QuestionViewModel::class.java)
    }

    private fun bindViewModel() {
        getViewDataBinding().viewModel = getViewModel()
    }

    private fun bindViewObserver() {
        getViewModel().output.start.observe(this, Observer {
            if (it) {
                initGame()
            } else {
                showError()
            }
        })
    }

    private fun initGame() {
        findNavController().navigate(R.id.action_questionStartFragment_to_questionFragment)
    }

    private fun showError() {
        Toast.makeText(context, "Falha ao carregar jogo", Toast.LENGTH_SHORT).show()
    }
}