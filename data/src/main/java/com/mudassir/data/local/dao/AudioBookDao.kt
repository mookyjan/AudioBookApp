package com.mudassir.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.mudassir.data.local.model.AudioBookLocalEntity
import com.mudassir.data.local.model.ListenHubAudioBookLocalEntity
import io.reactivex.Maybe

@Dao
interface AudioBookDao {

    @Query("SELECT * FROM audioBookList")
    fun getAudioBookList(): Maybe<AudioBookLocalEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg events: AudioBookLocalEntity)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(event: AudioBookLocalEntity)

    @Query("DELETE FROM audioBookList")
    fun deleteAllRepositories()
}