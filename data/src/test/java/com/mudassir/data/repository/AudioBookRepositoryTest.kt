package com.mudassir.data.repository

import com.mudassir.data.remote.GetAudioBooksRemoteDataSource
import com.mudassir.data.remote.model.mapToDomain
import com.mudassir.data.utils.TestData
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@Suppress("IllegalIdentifier")
@RunWith(MockitoJUnitRunner::class)
class AudioBookRepositoryTest{

    @Mock
    private lateinit var remoteDataSource: GetAudioBooksRemoteDataSource
    private lateinit var audioBookRepository: AudioBookRepository

    @Before
    fun setup(){
        audioBookRepository = AudioBookRepository(remoteDataSource)
    }

    @Test
    @Throws(Exception::class)
    fun `get list of audio book`(){

        //Given
        Mockito.`when`(remoteDataSource.getAudioBookList()).thenReturn(Single.just(TestData.getAudioBookResponse()))

        //When
        val testObserver = audioBookRepository.getAudioBookList().test().await()

        //should
        testObserver.assertComplete()
            .assertNoErrors()
            .assertValue(TestData.getAudioBookResponse())
    }

    @Test
    @Throws(Exception::class)
    fun `getAudioBook returns null if response is null`(){

        //Given
        val response =TestData.getAudioBookResponse()
        Mockito.`when`(remoteDataSource.getAudioBookList()).thenReturn(null)

        //when
        val testObserver = audioBookRepository.getAudioBookList()

        //should
       assertEquals(testObserver,null)
    }
}