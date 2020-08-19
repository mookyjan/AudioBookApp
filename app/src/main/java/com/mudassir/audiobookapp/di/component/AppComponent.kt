package com.mudassir.audiobookapp.di.component

import android.app.Application
import android.content.Context
import com.mudassir.audiobookapp.AudioBookApp
import com.mudassir.audiobookapp.di.module.*
import com.mudassir.data.NetworkModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
    AppModule::class,
    AndroidInjectionModule::class,
    ViewModelFactoryModule::class,
    FragmentModule::class,
    DomainModule::class,
    DataModule::class,
    NetworkModule::class
))
interface AppComponent {

    fun inject( application : AudioBookApp)

    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application : Application): Builder

        @BindsInstance
        fun context(context: Context) : Builder

        fun build(): AppComponent
    }
}