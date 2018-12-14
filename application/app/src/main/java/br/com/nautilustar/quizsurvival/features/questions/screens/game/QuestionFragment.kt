package br.com.nautilustar.quizsurvival.features.questions.screens.game

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import br.com.nautilustar.core.base.BaseFragment
import br.com.nautilustar.quizsurvival.R
import br.com.nautilustar.quizsurvival.databinding.FragmentQuestionBinding
import br.com.nautilustar.quizsurvival.features.questions.viewmodel.QuestionViewModel

class QuestionFragment
    : BaseFragment<FragmentQuestionBinding, QuestionViewModel>(),
    QuestionHandler {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_question
    }

    override fun getViewModel(): QuestionViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(QuestionViewModel::class.java)
    }

    override fun onNext() {
        getViewModel().input.next()
    }
}