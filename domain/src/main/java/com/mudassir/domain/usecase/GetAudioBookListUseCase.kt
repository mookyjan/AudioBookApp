package com.mudassir.domain.usecase

import com.mudassir.domain.SchedulerProvider
import com.mudassir.domain.UseCase
import com.mudassir.domain.entity.AudioBookEntity
import com.mudassir.domain.gateway.AudioBookGateWay
import io.reactivex.Single

class GetAudioBookListUseCase(schedulers: SchedulerProvider,
                              private val getAudioBookGateWay: AudioBookGateWay)
    : UseCase<Boolean,AudioBookEntity>(schedulers){

    override fun buildUseCaseObservable(refresh: Boolean): Single<AudioBookEntity> {

        return getAudioBookGateWay.getAudioBookList(refresh)
    }
}