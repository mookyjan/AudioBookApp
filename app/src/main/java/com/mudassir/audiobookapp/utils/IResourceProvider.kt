package com.mudassir.audiobookapp.utils

import android.content.Context
import javax.inject.Inject

class IResourceProvider @Inject constructor(private val context1: Context) {

    lateinit var context: Context

    init {
        this.context = context1
    }

    fun getString(resId: Int): String {
        return context.getString(resId)
    }

    fun getString(resId: Int, int: Int): String {
        return context.getString(resId, int)
    }

    fun getString(resId: Int, string: String): String {
        return context.getString(resId, string)
    }

    fun getString(resId: Int,int: Int,string: String):String{
        return context.getString(resId,int,string)
    }

    fun getStringArray(resId: Int): Array<String> {
        return context.resources.getStringArray(resId)
    }
}