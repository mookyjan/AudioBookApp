package com.mudassir.data.remote

import com.mudassir.data.remote.api.AudioBookService
import com.mudassir.data.remote.model.AudioBookResponse
import io.reactivex.Single

class GetAudioBooksRemoteDataSource (private val audioBookService: AudioBookService ) {

    fun getAudioBookList() : Single<AudioBookResponse>
     = audioBookService.getAudioBookList()
}