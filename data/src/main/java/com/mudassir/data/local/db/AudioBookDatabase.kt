package com.mudassir.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.mudassir.data.local.dao.AudioBookDao
import com.mudassir.data.local.model.AudioBookLocalEntity
import com.mudassir.data.local.model.Converters

@Database(entities = arrayOf(AudioBookLocalEntity::class),version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class AudioBookDatabase : RoomDatabase(){

    abstract fun audioBookDao() : AudioBookDao

    companion object{
        fun newInstance(context: Context): AudioBookDatabase{
            return Room.databaseBuilder(context,AudioBookDatabase::class.java,"audio_boo.db").build()
        }
    }

}