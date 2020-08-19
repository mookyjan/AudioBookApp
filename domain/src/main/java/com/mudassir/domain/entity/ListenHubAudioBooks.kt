package com.mudassir.domain.entity

data class ListenHubAudioBooks(
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
)