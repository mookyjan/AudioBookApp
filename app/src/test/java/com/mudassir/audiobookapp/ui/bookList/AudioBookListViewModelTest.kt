package com.mudassir.audiobookapp.ui.bookList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.mudassir.audiobookapp.model.mapToPresentation
import com.mudassir.audiobookapp.utils.IResourceProvider
import com.mudassir.audiobookapp.utils.audioBookEntity
import com.mudassir.domain.usecase.GetAudioBookListUseCase
import io.reactivex.Single
import org.hamcrest.core.Is
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner
import java.lang.RuntimeException

@RunWith(MockitoJUnitRunner::class)
class AudioBookListViewModelTest{

    @Mock
    private lateinit var getAudioBookListUseCase: GetAudioBookListUseCase

    @Mock
    private lateinit var iResourceProvider: IResourceProvider
    private lateinit var audioBookViewModel: AudioBookListViewModel

    //to update the value of mutableLive data instantly
    @get:Rule
    val rule = InstantTaskExecutorRule()


    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        audioBookViewModel = AudioBookListViewModel(getAudioBookListUseCase,iResourceProvider)
    }

    @Test
    fun `Given audio book list, when call audio book list , should update the audioBookList `(){

        //given
        val domainData = audioBookEntity

        Mockito.`when`(getAudioBookListUseCase.execute(true)).thenReturn(Single.just(domainData))

        //when
        audioBookViewModel.getAudioBookList()

        //should
        assertThat(audioBookViewModel.audioBookList.value, Is.`is`(domainData.listenHubAudioBooks.mapToPresentation()))

        //to check the size of the list
        val expectedValue=1
        assertNotNull(audioBookViewModel.audioBookList)

        assertEquals(expectedValue,audioBookViewModel.audioBookList.value?.size)
    }

    @Test
    @Throws(Exception::class)
    fun `Given error emission, when load repo list with error, should update error`(){

        //Given
        val error =RuntimeException("Unknown error")

        Mockito.`when`(getAudioBookListUseCase.execute(true)).thenReturn(Single.error(error))

        //when
        audioBookViewModel.getAudioBookList()

        //should
        assertThat(audioBookViewModel.error.value,Is.`is`(error.message))
    }

}