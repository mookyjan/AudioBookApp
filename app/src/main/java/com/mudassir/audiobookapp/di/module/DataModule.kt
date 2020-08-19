package com.mudassir.audiobookapp.di.module

import com.mudassir.data.gateway.AudioBookGateWayImpl
import com.mudassir.data.remote.GetAudioBooksRemoteDataSource
import com.mudassir.data.remote.api.AudioBookService
import com.mudassir.data.repository.AudioBookRepository
import com.mudassir.domain.gateway.AudioBookGateWay
import dagger.Module
import dagger.Provides

@Module
class DataModule {


    @Provides
    fun provideAudioBookRemoteDataSource(audioBookService: AudioBookService)
            = GetAudioBooksRemoteDataSource(audioBookService)

    @Provides
    fun provideAudioBookRepository(audioBooksRemoteDataSource: GetAudioBooksRemoteDataSource)
            = AudioBookRepository(audioBooksRemoteDataSource)

    @Provides
    fun provideAudioBookGateWay(audioBookRepository: AudioBookRepository): AudioBookGateWay
    = AudioBookGateWayImpl(audioBookRepository)
}