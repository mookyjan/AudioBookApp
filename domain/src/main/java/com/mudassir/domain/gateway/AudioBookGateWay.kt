package com.mudassir.domain.gateway

import com.mudassir.domain.entity.AudioBookEntity
import io.reactivex.Single

interface AudioBookGateWay {

    fun getAudioBookList( refresh: Boolean? = false): Single<AudioBookEntity>
}