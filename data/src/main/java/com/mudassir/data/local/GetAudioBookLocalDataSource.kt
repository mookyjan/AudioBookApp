package com.mudassir.data.local

import com.mudassir.data.local.dao.AudioBookDao
import com.mudassir.data.local.model.AudioBookLocalEntity
import io.reactivex.Single

class GetAudioBookLocalDataSource (private val  audioBookDao: AudioBookDao){

    fun getAudioBookList() : Single<AudioBookLocalEntity> = audioBookDao.getAudioBookList().toSingle()

    fun insertAudioBookList(audioBookLocalEntity: AudioBookLocalEntity) = audioBookDao.insert(audioBookLocalEntity)

    fun deleteAllData() = audioBookDao.deleteAllRepositories()


}