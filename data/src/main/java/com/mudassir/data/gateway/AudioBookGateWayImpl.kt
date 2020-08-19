package com.mudassir.data.gateway

import com.mudassir.data.remote.model.mapToDomain
import com.mudassir.data.repository.AudioBookRepository
import com.mudassir.domain.entity.AudioBookEntity
import com.mudassir.domain.gateway.AudioBookGateWay
import io.reactivex.Single

class AudioBookGateWayImpl (private val audioBookRepository: AudioBookRepository): AudioBookGateWay{


    override fun getAudioBookList(refresh: Boolean?): Single<AudioBookEntity> {
        return audioBookRepository.getAudioBookList().map {
            it.mapToDomain()
        }
    }

}