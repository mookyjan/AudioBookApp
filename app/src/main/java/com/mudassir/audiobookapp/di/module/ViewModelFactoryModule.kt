package com.mudassir.audiobookapp.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mudassir.audiobookapp.ui.bookDetails.BookDetailsViewModel
import com.mudassir.audiobookapp.ui.bookList.AudioBookListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(AudioBookListViewModel::class)
    abstract fun provideAudioBookListViewModel(viewModel: AudioBookListViewModel) : ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(BookDetailsViewModel::class)
    abstract fun provideBookDetailsViewModel(viewModel: BookDetailsViewModel):ViewModel

}