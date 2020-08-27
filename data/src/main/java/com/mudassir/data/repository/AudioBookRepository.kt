package com.mudassir.data.repository

import com.github.ajalt.timberkt.Timber
import com.mudassir.data.local.GetAudioBookLocalDataSource
import com.mudassir.data.local.mapper.AudioBookLocalMapper
import com.mudassir.data.local.model.AudioBookLocalEntity
import com.mudassir.data.remote.GetAudioBooksRemoteDataSource
import com.mudassir.data.remote.model.AudioBookResponse
import io.reactivex.Single

class AudioBookRepository(private val getAudioBooksRemoteDataSource: GetAudioBooksRemoteDataSource,
                          private val getuAudioBookLocalDataSource: GetAudioBookLocalDataSource) {

    fun getAudioBookList(refresh: Boolean? = false) : Single<AudioBookLocalEntity>{
       val  local = getDataFromLocalDb()
        val remoteData = getAudioBooksRemoteDataSource.getAudioBookList()
            .map { AudioBookLocalMapper.transformFrom(it) }
            .doOnSuccess {
                getuAudioBookLocalDataSource.insertAudioBookList(it)
            }

        var isSameData = false
      /*get data from api when force refresh or the local and server data is not same*/
       if(local.equals(remoteData) || refresh!!){
           isSameData=true
       }
        Timber.d { "is local db and api data is same or force refresh ${isSameData}" }
        return Single.just(isSameData)
            .flatMap {
                if (it)
                    getuAudioBookLocalDataSource.deleteAllData()
                Single.concat(local.onErrorResumeNext(remoteData), remoteData)
                    .firstElement().toSingle()
            }
    }

    fun getDataFromLocalDb() : Single<AudioBookLocalEntity>{
        val local = getuAudioBookLocalDataSource.getAudioBookList()
        return local
    }

}