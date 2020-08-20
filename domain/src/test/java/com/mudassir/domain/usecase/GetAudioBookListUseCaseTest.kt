package com.mudassir.domain.usecase

import com.mudassir.domain.SchedulerProvider
import com.mudassir.domain.entity.AudioBookEntity
import com.mudassir.domain.gateway.AudioBookGateWay
import com.mudassir.domain.utils.TestSchedulers
import com.mudassir.domain.utils.audioBookEntity
import com.nhaarman.mockito_kotlin.eq
import com.nhaarman.mockito_kotlin.mock
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@Suppress("IllegalIdentifier")
@RunWith(MockitoJUnitRunner::class)
class GetAudioBookListUseCaseTest{

    private lateinit var getAudioBookListUseCase: GetAudioBookListUseCase
    private val mockAudioBookListGateWay: AudioBookGateWay = mock()
    lateinit var schedulerProvider: SchedulerProvider

    @Before
    fun setUp(){
        schedulerProvider = TestSchedulers()
        getAudioBookListUseCase= GetAudioBookListUseCase(schedulerProvider,mockAudioBookListGateWay)
    }

    @Test
    fun `get list of audio book`(){

        //Given
        val mockList = audioBookEntity

        //when
        Mockito.`when`(mockAudioBookListGateWay.getAudioBookList(false)).thenReturn(eq(Single.just(mockList)))

        val testObserver =getAudioBookListUseCase.execute(false).test()

        //then
        testObserver.assertComplete()
            .assertNoErrors()
            .assertValue(mockList)

    }
}