package com.mudassir.data.remote.api

import com.mudassir.data.remote.model.AudioBookResponse
import io.reactivex.Single
import retrofit2.http.GET

interface AudioBookService {

    @GET("")
    fun getAudioBookList() : Single<List<AudioBookResponse>>
}