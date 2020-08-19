package com.mudassir.audiobookapp.ui.bookList

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.ajalt.timberkt.Timber
import com.mudassir.audiobookapp.model.AudioBookModel
import com.mudassir.audiobookapp.model.ListenHubAudioBooksModel
import com.mudassir.audiobookapp.model.mapToPresentation
import com.mudassir.audiobookapp.utils.IResourceProvider
import com.mudassir.domain.usecase.GetAudioBookListUseCase
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class AudioBookListViewModel @Inject constructor(private val audioBookListUseCase: GetAudioBookListUseCase,
                                                 private val iResourceProvider: IResourceProvider) : ViewModel() {


    //variable for loading progress
    val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading
    //variable for error message
    val error = MutableLiveData<String>()
    val empty = ObservableBoolean(true)
    private val _audioBookList =MutableLiveData<List<ListenHubAudioBooksModel>>()
    var audioBookList: LiveData<List<ListenHubAudioBooksModel>> = _audioBookList
    init {
        getAudioBookList()
    }

    /**
     * fun call audio book list api
     */
    fun getAudioBookList(){
        _loading.postValue(true)
        audioBookListUseCase.execute(true)
            .subscribeBy(onSuccess = {
                _loading.postValue(false)
                _audioBookList.postValue(it.listenHubAudioBooks.mapToPresentation())
//                audioBookList.addAll(it.listenHubAudioBooks.map {
//                    it.mapToPresentation()
//                })
                Timber.d { "audio book list $it" }
            },onError = {
                _loading.postValue(false)
                Timber.e { "error audio book api ${it.printStackTrace()}" }
            })
    }

    fun navigationComplete(){
        _audioBookList.value=null
        _loading.value=null
    }
}