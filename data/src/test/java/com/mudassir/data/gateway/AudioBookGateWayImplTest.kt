package com.mudassir.data.gateway

import com.mudassir.data.remote.model.mapToDomain
import com.mudassir.data.repository.AudioBookRepository
import com.mudassir.data.utils.TestData
import com.mudassir.data.utils.audioBookEntity
import com.mudassir.domain.gateway.AudioBookGateWay
import io.reactivex.Single
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AudioBookGateWayImplTest{

    @Mock
    private lateinit var audioBookRepository: AudioBookRepository
    private lateinit var audioBookGateWay: AudioBookGateWay

    @Before
    fun setup(){
        audioBookGateWay= AudioBookGateWayImpl(audioBookRepository)
    }

    @Test
    fun `Given audio book data,when get audio book response,Should fetch data from repository and then parese to domain`(){
        //Given
        val domainData = audioBookEntity
        val repositoryData = TestData.getAudioBookResponse()
        Mockito.`when`(audioBookRepository.getAudioBookList()).thenReturn(Single.just(repositoryData))

        //when
        val testObserver = audioBookGateWay.getAudioBookList().test().await()

        //then
        testObserver.assertComplete()
            .assertNoErrors()
            .assertValue(repositoryData.mapToDomain())
    }
}