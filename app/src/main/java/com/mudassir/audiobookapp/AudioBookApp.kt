package com.mudassir.audiobookapp

import android.app.Application
import com.github.ajalt.timberkt.Timber
import com.mudassir.audiobookapp.di.component.AppComponent
import com.mudassir.audiobookapp.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class AudioBookApp : Application(), HasAndroidInjector {

    @Inject
    lateinit var activityDispatcher: DispatchingAndroidInjector<Any>

    lateinit var component: AppComponent

    override fun androidInjector(): AndroidInjector<Any> {
        return activityDispatcher
    }
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        component = DaggerAppComponent
            .builder()
            .application(this)
            .context(this)
            .build()
        component.inject(this)
    }

}