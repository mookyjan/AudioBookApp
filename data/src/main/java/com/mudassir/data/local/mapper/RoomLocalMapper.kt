package com.mudassir.data.local.mapper

import com.mudassir.data.util.BaseMapper
import com.mudassir.data.local.model.AudioBookLocalEntity
import com.mudassir.data.local.model.AuthorsLocalEntity
import com.mudassir.data.local.model.ChapterLocalEntity
import com.mudassir.data.local.model.ListenHubAudioBookLocalEntity
import com.mudassir.data.remote.model.*
import com.mudassir.domain.entity.AudioBookEntity

object AudioBookLocalMapper: BaseMapper<AudioBookLocalEntity, AudioBookResponse>() {

    override fun transformFrom(source: AudioBookResponse): AudioBookLocalEntity {

        return AudioBookLocalEntity(id = 0,listenHubAudioBooks = ListenLocalMapper.transformToList(source.listenHubAudioBooks))
    }
    override fun transformTo(source: AudioBookLocalEntity): AudioBookResponse
    = AudioBookResponse(listenHubAudioBooks = ListenLocalMapper.transformFromList(source.listenHubAudioBooks))
}

object ListenLocalMapper: BaseMapper<ListenHubAudioBooks, ListenHubAudioBookLocalEntity>(){

    override fun transformFrom(source: ListenHubAudioBookLocalEntity): ListenHubAudioBooks
    = ListenHubAudioBooks(authors = AuthorLocalMapper.transformFromList(source.authors),
        chapterCount = source.chapterCount,
        chapters =ChapterLocalMapper.transformFromList(source.chapters)
        ,description = source.description,genres =  source.genres,
        imageUrl =source.imageUrl, language=source.language,
        title =source.title, totaltime = source.totaltime,
        totaltimesecs = source.totaltimesecs, url_zip_file = source.url_zip_file,id = "")

    override fun transformTo(source: ListenHubAudioBooks): ListenHubAudioBookLocalEntity
    = ListenHubAudioBookLocalEntity(authors = AuthorLocalMapper.transformToList(source.authors),
        chapterCount = source.chapterCount,
        chapters = ChapterLocalMapper.transformToList(source.chapters),description = source.description,genres =  source.genres,
        imageUrl =source.imageUrl, language=source.language, title =source.title, totaltime = source.totaltime,
        totaltimesecs = source.totaltimesecs, url_zip_file = source.url_zip_file,book_id =source.id)

}

object AuthorLocalMapper : BaseMapper<Authors, AuthorsLocalEntity>(){

    override fun transformFrom(source: AuthorsLocalEntity): Authors {
      return  Authors(dob = source.dob, dod =  source.dod, first_name =  source.first_name,
            id =  source.id, last_name =  source.last_name)
    }

    override fun transformTo(source: Authors): AuthorsLocalEntity {

      return  AuthorsLocalEntity(dob = source.dob, dod =  source.dod, first_name =  source.first_name,
            id =  source.id, last_name =  source.last_name)
    }

}

object ChapterLocalMapper : BaseMapper<Chapters, ChapterLocalEntity>(){

    override fun transformFrom(source: ChapterLocalEntity): Chapters
            = Chapters(duration = source.duration,link =  source.link,narratedBy =  source.narratedBy,title =  source.title)

    override fun transformTo(source: Chapters): ChapterLocalEntity
    = ChapterLocalEntity(duration = source.duration,link =  source.link,narratedBy =  source.narratedBy,title =  source.title)
}


object AudioBookLocalToDomainMapper: BaseMapper<AudioBookLocalEntity, AudioBookEntity>() {

    override fun transformFrom(source: AudioBookEntity): AudioBookLocalEntity {
        return AudioBookLocalEntity(id = 0,listenHubAudioBooks
        = ListenLocalToDomainMapper.transformFromList(source.listenHubAudioBooks))
    }
    override fun transformTo(source: AudioBookLocalEntity): AudioBookEntity
            = AudioBookEntity(listenHubAudioBooks = ListenLocalToDomainMapper.transformToList(source.listenHubAudioBooks))
}

object ListenLocalToDomainMapper: BaseMapper<ListenHubAudioBookLocalEntity, com.mudassir.domain.entity.ListenHubAudioBooks>(){

    override fun transformFrom(source: com.mudassir.domain.entity.ListenHubAudioBooks): ListenHubAudioBookLocalEntity
            = ListenHubAudioBookLocalEntity(authors = AuthorLocalToDomainMapper.transformFromList(source.authors),
        chapterCount = source.chapterCount,
        chapters =ChapterLocalToDomainMapper.transformFromList(source.chapters)
        ,description = source.description,genres =  source.genres,
        imageUrl =source.imageUrl, language=source.language,
        title =source.title, totaltime = source.totaltime,
        totaltimesecs = source.totaltimesecs, url_zip_file = source.url_zip_file,book_id = source.id)

    override fun transformTo(source: ListenHubAudioBookLocalEntity): com.mudassir.domain.entity.ListenHubAudioBooks
         = com.mudassir.domain.entity.ListenHubAudioBooks(authors = AuthorLocalToDomainMapper.transformToList(source.authors),
        chapterCount = source.chapterCount,
        chapters = ChapterLocalToDomainMapper.transformToList(source.chapters),description = source.description,genres =  source.genres,
        imageUrl =source.imageUrl, language=source.language, title =source.title, totaltime = source.totaltime,
        totaltimesecs = source.totaltimesecs, url_zip_file = source.url_zip_file,id = source.book_id)
}

object AuthorLocalToDomainMapper : BaseMapper<AuthorsLocalEntity, com.mudassir.domain.entity.Authors>(){

    override fun transformFrom(source: com.mudassir.domain.entity.Authors): AuthorsLocalEntity {
        return  AuthorsLocalEntity(dob = source.dob, dod =  source.dod, first_name =  source.first_name,
            id =  source.id, last_name =  source.last_name)
    }

    override fun transformTo(source: AuthorsLocalEntity): com.mudassir.domain.entity.Authors {
        return  com.mudassir.domain.entity.Authors(dob = source.dob, dod =  source.dod, first_name =  source.first_name,
            id =  source.id, last_name =  source.last_name)
    }

}

object ChapterLocalToDomainMapper : BaseMapper<ChapterLocalEntity, com.mudassir.domain.entity.Chapters>() {

    override fun transformFrom(source: com.mudassir.domain.entity.Chapters): ChapterLocalEntity =
        ChapterLocalEntity(
            duration = source.duration,
            link = source.link,
            narratedBy = source.narratedBy,
            title = source.title
        )

    override fun transformTo(source: ChapterLocalEntity): com.mudassir.domain.entity.Chapters =
        com.mudassir.domain.entity.Chapters(
            duration = source.duration,
            link = source.link,
            narratedBy = source.narratedBy,
            title = source.title
        )
}