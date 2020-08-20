package com.mudassir.domain.utils

import com.mudassir.domain.entity.AudioBookEntity
import com.mudassir.domain.entity.Authors
import com.mudassir.domain.entity.Chapters
import com.mudassir.domain.entity.ListenHubAudioBooks
import com.nhaarman.mockito_kotlin.any
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString

val authorsEntity = Authors(dob = "1802",dod = "1870",first_name = "Alexander",id = "431",last_name = "Dumas")
val chaptersEntity = Chapters(duration = "00:19:17",link = "http://www.archive.org/download/count_monte_cristo_0711_librivox/count_of_monte_cristo_002_dumas_64kb.mp3",
    narratedBy = "Gord Mackenzie",title = "Father and Son")
val listenAudioBookEntity = ListenHubAudioBooks(listOf(authorsEntity),chapterCount = "128",chapters = listOf(
    chaptersEntity),
    description = "The count of monte",genres = "LIbrary Fiction",id = "47",
    imageUrl = "http://www.archive.org/download/LibrivoxCdCoverArt12/Letters_Two_Brides_1110.jpg",
    language = "English",
    totaltime ="9:09:20",totaltimesecs = "32960.0",
    title ="Letters of Two Brides",url_zip_file ="http://www.archive.org/download/letters_brides_0709_librivox/letters_brides_0709_librivox_64kb_mp3.zip"
)
val audioBookEntity = AudioBookEntity(listenHubAudioBooks = listOf(listenAudioBookEntity))