package com.mudassir.audiobookapp.di.module

import com.mudassir.audiobookapp.ui.bookDetails.BookDetailsFragment
import com.mudassir.audiobookapp.ui.bookList.AudioBookListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {

    @ContributesAndroidInjector
    abstract fun audioBookListFragment() : AudioBookListFragment

    @ContributesAndroidInjector
    abstract fun bookDetailFragment(): BookDetailsFragment
}