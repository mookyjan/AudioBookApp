package com.mudassir.audiobookapp.ui.bookDetails

import android.R
import android.net.Uri
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mudassir.audiobookapp.AudioBookApp
import com.mudassir.audiobookapp.model.ListenHubAudioBooksModel
import com.mudassir.audiobookapp.player.MediaPlayerImpl
import com.mudassir.audiobookapp.utils.IResourceProvider
import java.lang.ref.WeakReference
import javax.inject.Inject


class BookDetailsViewModel @Inject constructor(iResourceProvider: IResourceProvider) : ViewModel() {

    val _listenHubAudioBooksModel= MutableLiveData<ListenHubAudioBooksModel>()

    val listenHubAudioBooksModel : LiveData<ListenHubAudioBooksModel> = _listenHubAudioBooksModel

//    private val view = WeakReference(videoViewView)

    init {

    }
    private val mediaPlayer = MediaPlayerImpl(iResourceProvider.context)

   fun deactivate() {
    }

     fun getPlayer() = mediaPlayer

     fun play(url: String) = mediaPlayer.play(url)

     fun releasePlayer() = mediaPlayer.releasePlayer()

     fun setMediaSessionState(isActive: Boolean) {
        mediaPlayer.setMediaSessionState(isActive)
    }


}