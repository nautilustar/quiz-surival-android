package br.com.nautilustar.quizsurvival.features.questions.actvities

import androidx.lifecycle.ViewModelProviders
import br.com.nautilustar.core.base.BaseActivity
import br.com.nautilustar.quizsurvival.databinding.ActivityQuestionBinding
import br.com.nautilustar.quizsurvival.R
import br.com.nautilustar.quizsurvival.features.questions.viewmodel.QuestionViewModel

class QuestionActivity : BaseActivity<ActivityQuestionBinding, QuestionViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_question
    }

    override fun getViewModel(): QuestionViewModel {
        return ViewModelProviders
            .of(this, viewModelFactory)
            .get(QuestionViewModel::class.java)
    }
}