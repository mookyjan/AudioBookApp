package com.mudassir.data.local.model

import androidx.room.*


@Entity(tableName = "audioBookList")
class AudioBookLocalEntity (
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    @ColumnInfo(name ="listenHubAudioBooks")
    @TypeConverters(Converters::class)
    val listenHubAudioBooks: List<ListenHubAudioBookLocalEntity>

)


@Entity(tableName = "audioBook")
data class ListenHubAudioBookLocalEntity(
    @PrimaryKey()
    val book_id: String,
    val authors: List<AuthorsLocalEntity>,
    val chapterCount: String,
    val chapters: List<ChapterLocalEntity>,
    val description: String,
    val genres: String,
    val imageUrl: String,
    val language: String,
    val title: String,
    val totaltime: String,
    val totaltimesecs: String,
    val url_zip_file: String
)

@Entity(tableName = "authors")
data class AuthorsLocalEntity(
    val dob: String,
    val dod: String,
    val first_name: String,
    val id: String,
    val last_name: String
)

@Entity(tableName = "chapters")
data class ChapterLocalEntity(
    val duration: String,
    val link: String,
    val narratedBy: String,
    val title: String
)

