package br.com.nautilustar.domain.interactor

import br.com.nautilustar.domain.UseCase
import br.com.nautilustar.domain.executor.ThreadExecutor
import br.com.nautilustar.domain.executor.PostExecutionThread
import br.com.nautilustar.domain.model.QuestionModel
import br.com.nautilustar.domain.repository.QuestionRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetQuestion @Inject constructor(
    private val questionRepository: QuestionRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
) : UseCase<List<QuestionModel>, Void>(threadExecutor, postExecutionThread) {

    override fun buildUseCaseObservable(params: Void?): Observable<List<QuestionModel>> {
        return questionRepository.getQuestions()
    }

}