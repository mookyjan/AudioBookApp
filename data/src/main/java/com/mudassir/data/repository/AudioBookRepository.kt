package com.mudassir.data.repository

import com.mudassir.data.remote.GetAudioBooksRemoteDataSource
import com.mudassir.data.remote.model.AudioBookResponse
import io.reactivex.Single

class AudioBookRepository(private val getAudioBooksRemoteDataSource: GetAudioBooksRemoteDataSource) {

    fun getAudioBookList() : Single<AudioBookResponse>{

        val remoteData = getAudioBooksRemoteDataSource.getAudioBookList()
        return remoteData
    }

}