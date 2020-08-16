package com.mudassir.domain

import io.reactivex.Single

abstract class UseCase<in Params,T> protected constructor(private val schedulers:SchedulerProvider) {

    protected abstract fun buildUseCaseObservable(params: Params): Single<T>

    fun execute(params: Params) : Single<T> {
        val observable = this.buildUseCaseObservable(params)
            .subscribeOn(schedulers.subscribeOn)
            .observeOn(schedulers.observeOn)
        return observable
    }

}