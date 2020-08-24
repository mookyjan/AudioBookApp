package com.mudassir.audiobookapp.ui.bookList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.github.ajalt.timberkt.Timber
import com.mudassir.audiobookapp.R
import com.mudassir.audiobookapp.model.ListenHubAudioBooksModel
import com.mudassir.audiobookapp.model.mapToPresentation
import com.mudassir.audiobookapp.ui.base.BaseViewModel
import com.mudassir.audiobookapp.utils.IResourceProvider
import com.mudassir.domain.usecase.GetAudioBookListUseCase
import io.reactivex.rxkotlin.addTo
import io.reactivex.rxkotlin.subscribeBy
import javax.inject.Inject

class AudioBookListViewModel @Inject constructor(private val audioBookListUseCase: GetAudioBookListUseCase,
                                                 private val iResourceProvider: IResourceProvider) : BaseViewModel() {

    private val _audioBookList =MutableLiveData<List<ListenHubAudioBooksModel>>()
    var audioBookList: LiveData<List<ListenHubAudioBooksModel>> = _audioBookList


    /**
     * fun call audio book list api
     */
    fun getAudioBookList(){
        _loading.postValue(true)
        audioBookListUseCase.execute(true)
            .subscribeBy(onSuccess = {
                _loading.postValue(false)
                _audioBookList.postValue(it.listenHubAudioBooks.mapToPresentation())
                Timber.d { "audio book list $it" }
            },onError = {e->
                _loading.postValue(false)
                _error.postValue(e.localizedMessage ?: e.message ?: iResourceProvider.context.getString(R.string.txt_unknown_error))
                Timber.e { "error audio book api ${e.printStackTrace()}" }
            }).addTo(compositeDisposable)
    }

//    fun navigationComplete(){
//        val navDirections = AudioBookListFragmentDirections.actionAudioBookListFragmentToBookDetailsFragment()
//        navManager.getArgs()
//        navManager.navigate(navDirections)
//    }
}