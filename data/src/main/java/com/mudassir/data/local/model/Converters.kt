package com.mudassir.data.local.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types

class Converters {

    @TypeConverter
    fun fromAudioBookList(value: List<ListenHubAudioBookLocalEntity>):String{
      val gson = Gson()
        val type =object : TypeToken<List<ListenHubAudioBookLocalEntity>>(){}.type
        return gson.toJson(value,type)

        }

    @TypeConverter
    fun toAudioBookList(value:String) : List<ListenHubAudioBookLocalEntity>{
        val gson= Gson()
        val type =object :TypeToken<List<ListenHubAudioBookLocalEntity>>(){}.type
        return gson.fromJson(value,type)
    }

    @TypeConverter
    fun fromAuthorsList(value: List<AuthorsLocalEntity>):String{
        val moshi =Moshi.Builder().build()
        val type =Types.newParameterizedType(List::class.java,AuthorsLocalEntity::class.java)
        val adapter = moshi.adapter<List<AuthorsLocalEntity>>(type)
        return adapter.toJson(value)
    }

    @TypeConverter
    fun toAuthorList(value: String): List<AuthorsLocalEntity>?{
        val moshi = Moshi.Builder().build()
        val type = Types.newParameterizedType(List::class.java, AuthorsLocalEntity::class.java)
        val adapter = moshi.adapter<List<AuthorsLocalEntity>>(type)
        return adapter.fromJson(value)
    }
}