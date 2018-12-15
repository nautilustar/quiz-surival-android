package br.com.nautilustar.quizsurvival.features.questions.screens

import androidx.lifecycle.ViewModelProviders
import br.com.nautilustar.core.base.BaseActivity
import br.com.nautilustar.core.base.BaseViewModel
import br.com.nautilustar.quizsurvival.R
import br.com.nautilustar.quizsurvival.databinding.ActivityQuestionBinding

class QuestionActivity : BaseActivity<ActivityQuestionBinding, BaseViewModel>() {

    override fun getLayoutId(): Int {
        return R.layout.activity_question
    }

    override fun getViewModel(): BaseViewModel {
        return ViewModelProviders
            .of(this, viewModelFactory)
            .get(BaseViewModel::class.java)
    }
}