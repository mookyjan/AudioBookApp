package com.mudassir.audiobookapp.di.module

import com.mudassir.domain.SchedulerProvider
import com.mudassir.domain.gateway.AudioBookGateWay
import com.mudassir.domain.usecase.GetAudioBookListUseCase
import dagger.Module
import dagger.Provides

@Module
class DomainModule {

    @Provides
    fun provideDomainModule(schedulerProvider: SchedulerProvider,audioBookGateWay: AudioBookGateWay)
    = GetAudioBookListUseCase(schedulerProvider,audioBookGateWay)

}