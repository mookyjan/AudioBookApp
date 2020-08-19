package com.mudassir.data.remote.api

import com.mudassir.data.remote.model.AudioBookResponse
import io.reactivex.Single
import retrofit2.http.GET

interface AudioBookService {

    @GET("ListenHub1593292901394.json?alt=media&token=6076663c-18b9-46f9-a5d5-2823b093a5b2")
    fun getAudioBookList() : Single<AudioBookResponse>
}