package com.mudassir.audiobookapp.di.module

import android.content.Context
import com.mudassir.data.gateway.AudioBookGateWayImpl
import com.mudassir.data.local.GetAudioBookLocalDataSource
import com.mudassir.data.local.dao.AudioBookDao
import com.mudassir.data.local.db.AudioBookDatabase
import com.mudassir.data.remote.GetAudioBooksRemoteDataSource
import com.mudassir.data.remote.api.AudioBookService
import com.mudassir.data.repository.AudioBookRepository
import com.mudassir.domain.gateway.AudioBookGateWay
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {


    @Provides
    fun provideAudioBookRemoteDataSource(audioBookService: AudioBookService)
            = GetAudioBooksRemoteDataSource(audioBookService)


    @Provides
    @Singleton
    fun provideAudioBookDatabase(context: Context) =
        AudioBookDatabase.newInstance(context)

    @Provides
    @Singleton
    fun provideAudioBookDao(audioBookDatabase: AudioBookDatabase)
     = audioBookDatabase.audioBookDao()

    @Provides
    @Singleton
    fun provideLocalDataSource(audioBookDao: AudioBookDao)
    = GetAudioBookLocalDataSource(audioBookDao)

    @Provides
    fun provideAudioBookRepository(audioBooksRemoteDataSource: GetAudioBooksRemoteDataSource,audioBookLocalDataSource: GetAudioBookLocalDataSource)
            = AudioBookRepository(audioBooksRemoteDataSource,audioBookLocalDataSource)

    @Provides
    fun provideAudioBookGateWay(audioBookRepository: AudioBookRepository): AudioBookGateWay
    = AudioBookGateWayImpl(audioBookRepository)
}