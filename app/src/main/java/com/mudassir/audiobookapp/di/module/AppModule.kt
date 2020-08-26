package com.mudassir.audiobookapp.di.module

import android.app.Application
import android.content.Context
import com.mudassir.audiobookapp.di.module.scheduler.AppSchedulers
import com.mudassir.audiobookapp.ui.bookList.adapter.AudioBookListAdapter
import com.mudassir.audiobookapp.utils.IResourceProvider
import com.mudassir.domain.SchedulerProvider
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    @Named("application.Context")
    fun provideContext(application: Application) : Context{
        return application.applicationContext
    }

    @Provides
    @Singleton
    fun provideSchedulers() : SchedulerProvider = AppSchedulers()

    @Provides
    @Singleton
    fun provideResource(context: Context) = IResourceProvider(context)

    @Provides
    fun provideAudioBookListAdapter() : AudioBookListAdapter = AudioBookListAdapter()
}