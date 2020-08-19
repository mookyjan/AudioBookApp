package com.mudassir.audiobookapp.ui.bookDetails

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.github.ajalt.timberkt.Timber
import com.google.android.exoplayer2.ExoPlayer
import com.mudassir.audiobookapp.AppConstants
import com.mudassir.audiobookapp.R
import com.mudassir.audiobookapp.databinding.BookDetailsFragmentBinding
import com.mudassir.audiobookapp.di.module.ViewModelFactory
import com.mudassir.audiobookapp.model.Chapters
import com.mudassir.audiobookapp.model.ListenHubAudioBooksModel
import com.mudassir.audiobookapp.ui.bookDetails.adapter.BookChapterAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


class BookDetailsFragment : Fragment(), BookChapterAdapter.Callbacks {

    companion object {
        fun newInstance() = BookDetailsFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel: BookDetailsViewModel
    private lateinit var  audioBookModel:ListenHubAudioBooksModel
    private lateinit var mBinding: BookDetailsFragmentBinding
    private lateinit var mChapterAdapter: BookChapterAdapter
    private lateinit var exoPlayer: ExoPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         audioBookModel = arguments?.getParcelable(AppConstants.AUDIO_BOOK_ARGU)!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = DataBindingUtil.inflate(inflater,
            R.layout.book_details_fragment, container, false)

        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,this.viewModelFactory).get(BookDetailsViewModel::class.java)
        mBinding.viewModel=viewModel
//        mBinding.callback=this
        viewModel._listenHubAudioBooksModel.value=audioBookModel
        exoPlayer=viewModel.getPlayer().getPlayerImpl(activity as Context)
        mBinding.epVideoView.player=exoPlayer
        observeEvents()
    }

    fun observeEvents(){
        viewModel.listenHubAudioBooksModel.observe(viewLifecycleOwner, Observer {
            mChapterAdapter = BookChapterAdapter(it.chapters,this)
            mBinding.rvChapters.adapter=mChapterAdapter
//            it.chapters.let {
//                playVideo(it.get(0).link)
//            }
        })
    }


    override fun onPause() {
        super.onPause()
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            viewModel.releasePlayer()
        }
    }

    override fun onStop() {
        super.onStop()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            viewModel.releasePlayer()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel.deactivate()
        viewModel.setMediaSessionState(false)
    }

    private fun playVideo(videoUrl:String) {
        viewModel.deactivate()
        viewModel.setMediaSessionState(false)
        viewModel.play(videoUrl)
    }

    override fun onBookItemClick(view: View, item: Chapters) {
        Timber.d { "click on book Chapter ${item.link}" }
        // here you will get mItem and from that you can get the sound

        // here you will get mItem and from that you can get the sound
//        val video: Uri = Uri.parse(item.link)
//        val mediaPlayer: MediaPlayer = MediaPlayer.create(activity as Context,video )
//        mediaPlayer.start()
        playVideo(item.link)
    }
}



//fun videoPlayerSetup(link:String){
//        try {
////            val link =
////                "http://s1133.photobucket.com/albums/m590/Anniebabycupcakez/?action=view&amp; current=1376992942447_242.mp4"
//            val videoView: VideoView = mBinding.videoView
//            val mediaController = MediaController(activity)
//            mediaController.setAnchorView(videoView)
//            val video: Uri = Uri.parse(link)
//            videoView.setMediaController(mediaController)
//            videoView.setVideoURI(video)
//            videoView.start()
//        } catch (e: Exception) {
//            // TODO: handle exception
//
//        }
//    }

//}