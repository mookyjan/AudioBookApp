package com.mudassir.data.remote.model

import com.mudassir.domain.entity.AudioBookEntity
import com.squareup.moshi.Json

data class AudioBookResponse (

    @Json(name = "ListenHubAudioBooks") val listenHubAudioBooks : List<ListenHubAudioBooks>
)

data class ListenHubAudioBooks (
    @Json(name = "authors") val authors : List<Authors>,
    @Json(name = "chapterCount") val chapterCount : String,
    @Json(name = "chapters") val chapters : List<Chapters>,
    @Json(name = "description") val description : String,
    @Json(name = "genres") val genres : String,
    @Json(name = "id") val id : String,
    @Json(name = "imageUrl") val imageUrl : String,
    @Json(name = "language") val language : String,
    @Json(name = "title") val title : String,
    @Json(name = "totaltime") val totaltime : String,
    @Json(name = "totaltimesecs") val totaltimesecs : String,
    @Json(name = "url_zip_file") val url_zip_file : String
)

data class Chapters (

    @Json(name = "duration") val duration : String,
    @Json(name = "link") val link : String,
    @Json(name = "narratedBy") val narratedBy : String,
    @Json(name = "title") val title : String
)

data class Authors (
    @Json(name = "dob") val dob : String,
    @Json(name = "dod") val dod : String,
    @Json(name = "first_name") val first_name : String,
    @Json(name = "id") val id : String,
    @Json(name = "last_name") val last_name : String
)

 fun Authors.mapToDomain() : com.mudassir.domain.entity.Authors
  = com.mudassir.domain.entity.Authors(dob, dod, first_name, id, last_name)

fun List<Authors>.mapLisToDomain() : List<com.mudassir.domain.entity.Authors>
  = map { it.mapToDomain() }

fun Chapters.mapToDomain() : com.mudassir.domain.entity.Chapters
  = com.mudassir.domain.entity.Chapters(duration, link, narratedBy, title)

fun List<Chapters>.mapListToDomain(): List<com.mudassir.domain.entity.Chapters>
  = map { it.mapToDomain() }

 fun ListenHubAudioBooks.mapToDomain(): com.mudassir.domain.entity.ListenHubAudioBooks
=  com.mudassir.domain.entity.ListenHubAudioBooks(this.authors.mapLisToDomain(),chapterCount,
    this.chapters.mapListToDomain(),description, genres, id, imageUrl, language, title, totaltime, totaltimesecs, url_zip_file)

fun List<ListenHubAudioBooks>.mapToDomain(): List<com.mudassir.domain.entity.ListenHubAudioBooks>
   = map { it.mapToDomain() }
fun AudioBookResponse.mapToDomain() : AudioBookEntity
  = AudioBookEntity(listenHubAudioBooks = listenHubAudioBooks.mapToDomain())