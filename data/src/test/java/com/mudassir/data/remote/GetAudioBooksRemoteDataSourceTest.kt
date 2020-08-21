package com.mudassir.data.remote

import com.mudassir.data.NetworkModule
import com.mudassir.data.remote.api.AudioBookService
import com.mudassir.data.utils.TestData
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetAudioBooksRemoteDataSourceTest{

    @Mock
    private lateinit var audioBookService: AudioBookService

    private lateinit var  networkModule: NetworkModule
    private lateinit var remoteDataSource: GetAudioBooksRemoteDataSource

    @Before
    fun setup(){
        remoteDataSource = GetAudioBooksRemoteDataSource(audioBookService)
    }

    @Test
    fun `get list of audio book from api`(){
        //Given
        val result = Single.just(TestData.getAudioBookResponse())
        //when
        Mockito.`when`(remoteDataSource.getAudioBookList()).thenReturn(result)

        val response = audioBookService.getAudioBookList()
        //should
         assertNotNull(response)
         assertEquals(result.blockingGet(),response.blockingGet())
       //also check the size of the list will be 1
        assertEquals(1,response.blockingGet().listenHubAudioBooks.size)
    }


}