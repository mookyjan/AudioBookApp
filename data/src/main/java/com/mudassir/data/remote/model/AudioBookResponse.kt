package com.mudassir.data.remote.model

import com.squareup.moshi.Json

data class AudioBookResponse (

    @Json(name = "ListenHubAudioBooks") val listenHubAudioBooks : List<ListenHubAudioBooks>
)


data class ListenHubAudioBooks (

    @Json(name = "authors") val authors : List<Authors>,
    @Json(name = "chapterCount") val chapterCount : Int,
    @Json(name = "chapters") val chapters : List<Chapters>,
    @Json(name = "description") val description : String,
    @Json(name = "genres") val genres : String,
    @Json(name = "id") val id : Int,
    @Json(name = "imageUrl") val imageUrl : String,
    @Json(name = "language") val language : String,
    @Json(name = "title") val title : String,
    @Json(name = "totaltime") val totaltime : String,
    @Json(name = "totaltimesecs") val totaltimesecs : Int,
    @Json(name = "url_zip_file") val url_zip_file : String
)

data class Chapters (

    @Json(name = "duration") val duration : String,
    @Json(name = "link") val link : String,
    @Json(name = "narratedBy") val narratedBy : String,
    @Json(name = "title") val title : String
)

data class Authors (
    @Json(name = "dob") val dob : Int,
    @Json(name = "dod") val dod : Int,
    @Json(name = "first_name") val first_name : String,
    @Json(name = "id") val id : Int,
    @Json(name = "last_name") val last_name : String
)