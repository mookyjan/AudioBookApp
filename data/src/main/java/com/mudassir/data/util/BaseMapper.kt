package com.mudassir.data.util

import com.mudassir.data.remote.model.Authors
import com.mudassir.data.remote.model.mapToDomain

abstract class BaseMapper<T, K> {

    abstract fun transformFrom(source: K): T

    abstract fun transformTo(source: T): K

    fun transformFromList(source: List<K>): List<T> {
        return source.map { src -> transformFrom(src) }
    }
    fun transformToList(source: List<T>): List<K> {
        return source.map { src -> transformTo(src) }
    }

    fun List<Authors>.mapLisToDomain() : List<com.mudassir.domain.entity.Authors>
            = map { it.mapToDomain() }

    fun toList(source: List<T>):List<K> = source.map { src -> transformTo(src) }

}