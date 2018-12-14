package br.com.nautilustar.domain.executor

import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PostExecutionThread @Inject constructor() : IPostExecutionThread {

    override fun getScheduler(): Scheduler {
        return Schedulers.io()
    }
}