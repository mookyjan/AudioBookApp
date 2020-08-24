package com.mudassir.data.utils

import com.mudassir.data.remote.model.AudioBookResponse
import com.mudassir.data.remote.model.Authors
import com.mudassir.data.remote.model.Chapters
import com.mudassir.data.remote.model.ListenHubAudioBooks
import com.mudassir.domain.entity.AudioBookEntity

object TestData {

    internal fun getAuthors(dob :String= "1802",dod:String = "1870",
                            first_name:String = "Alexander",
                            id :String= "431",last_name:String = "Dumas"):Authors
            = Authors(dob, dod, first_name, id, last_name)

    internal fun getChapters(duration:String = "00:19:17",link:String = "http://www.archive.org/download/count_monte_cristo_0711_librivox/count_of_monte_cristo_002_dumas_64kb.mp3",
                             narratedBy:String = "Gord Mackenzie",title:String = "Father and Son"): Chapters
    = Chapters(duration, link, narratedBy, title)

    internal fun getListenAudioBook(authors: List<Authors> = listOf(getAuthors()), chapterCount:String = "128",
                                    chapters: List<Chapters> = listOf(getChapters()),
                                    description:String = "The count of monte", genres:String = "LIbrary Fiction", id:String = "47",
                                    imageUrl:String = "http://www.archive.org/download/LibrivoxCdCoverArt12/Letters_Two_Brides_1110.jpg",
                                    language:String = "English",
                                    totaltime:String ="9:09:20", totaltimesecs:String = "32960.0",
                                    title:String ="Letters of Two Brides", url_zip_file:String="http://www.archive.org/download/letters_brides_0709_librivox/letters_brides_0709_librivox_64kb_mp3.zip")
    = ListenHubAudioBooks(authors, chapterCount, chapters, description, genres, id, imageUrl, language, title, totaltime, totaltimesecs, url_zip_file)

   internal fun getAudioBookResponse(listenHubAudioBooks: List<ListenHubAudioBooks> = listOf(getListenAudioBook())) =
       AudioBookResponse(listenHubAudioBooks)

}

val authorsEntity = com.mudassir.domain.entity.Authors(
    dob = "1802",
    dod = "1870",
    first_name = "Alexander",
    id = "431",
    last_name = "Dumas"
)
val chaptersEntity = com.mudassir.domain.entity.Chapters(
    duration = "00:19:17",
    link = "http://www.archive.org/download/count_monte_cristo_0711_librivox/count_of_monte_cristo_002_dumas_64kb.mp3",
    narratedBy = "Gord Mackenzie",
    title = "Father and Son"
)
val listenAudioBookEntity = com.mudassir.domain.entity.ListenHubAudioBooks(
    listOf(authorsEntity),
    chapterCount = "128",
    chapters = listOf(
        chaptersEntity
    ),
    description = "The count of monte",
    genres = "LIbrary Fiction",
    id = "47",
    imageUrl = "http://www.archive.org/download/LibrivoxCdCoverArt12/Letters_Two_Brides_1110.jpg",
    language = "English",
    totaltime = "9:09:20",
    totaltimesecs = "32960.0",
    title = "Letters of Two Brides",
    url_zip_file = "http://www.archive.org/download/letters_brides_0709_librivox/letters_brides_0709_librivox_64kb_mp3.zip"
)
val audioBookEntity = AudioBookEntity(listenHubAudioBooks = listOf(listenAudioBookEntity))