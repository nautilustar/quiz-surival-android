package br.com.nautilustar.quizsurvival.features.questions.fragments

import androidx.lifecycle.ViewModelProviders
import br.com.nautilustar.core.base.BaseFragment
import br.com.nautilustar.quizsurvival.R
import br.com.nautilustar.quizsurvival.databinding.FragmentQuestionBinding
import br.com.nautilustar.quizsurvival.features.questions.viewmodel.QuestionViewModel

class QuestionFragment : BaseFragment<FragmentQuestionBinding, QuestionViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_question
    }

    override fun getViewModel(): QuestionViewModel {
        return ViewModelProviders.of(this, viewModelFactory).get(QuestionViewModel::class.java)
    }
}