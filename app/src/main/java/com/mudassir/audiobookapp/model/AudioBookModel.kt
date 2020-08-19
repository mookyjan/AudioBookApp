package com.mudassir.audiobookapp.model

import android.os.Parcelable
import com.mudassir.domain.entity.AudioBookEntity
import kotlinx.android.parcel.Parcelize

data class AudioBookModel (
    val listenHubAudioBooks: List<ListenHubAudioBooksModel>
)

@Parcelize
data class ListenHubAudioBooksModel(
     val authors: List<Authors>,
    val chapterCount: String,
    val chapters: List<Chapters>,
    val description: String,
    val genres: String,
    val id: String,
    val imageUrl: String,
    val language: String,
    val title: String,
    val totaltime: String,
    val totaltimesecs: String,
    val url_zip_file: String
): Parcelable

@Parcelize
data class Chapters(
    val duration: String,
    val link: String,
    val narratedBy: String,
    val title: String
):Parcelable

@Parcelize
data class Authors(
    val dob: String,
    val dod: String,
    val first_name: String,
    val id: String,
    val last_name: String
):Parcelable

fun com.mudassir.domain.entity.Authors.mapToPresentation() : Authors
        = Authors(dob, dod, first_name, id, last_name)

fun List<com.mudassir.domain.entity.Authors>.mapLisToDomain() : List<Authors>
        = map { it.mapToPresentation() }

fun com.mudassir.domain.entity.Chapters.mapToPresentation() : Chapters
        = Chapters(duration, link, narratedBy, title)

fun List<com.mudassir.domain.entity.Chapters>.mapListToDomain(): List<Chapters>
        = map { it.mapToPresentation() }

fun com.mudassir.domain.entity.ListenHubAudioBooks.mapToPresentation(): ListenHubAudioBooksModel
        = ListenHubAudioBooksModel(this.authors.mapLisToDomain(),chapterCount,
    this.chapters.mapListToDomain(),description, genres, id, imageUrl, language, title, totaltime, totaltimesecs, url_zip_file)

fun List<com.mudassir.domain.entity.ListenHubAudioBooks>.mapToPresentation(): List<ListenHubAudioBooksModel>
        = map { it.mapToPresentation() }
fun AudioBookEntity.mapToPresentation() : AudioBookModel
        = AudioBookModel(listenHubAudioBooks = listenHubAudioBooks.mapToPresentation())