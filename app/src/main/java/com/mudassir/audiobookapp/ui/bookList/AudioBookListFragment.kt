package com.mudassir.audiobookapp.ui.bookList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.github.ajalt.timberkt.Timber
import com.mudassir.audiobookapp.AppConstants
import com.mudassir.audiobookapp.MainActivity
import com.mudassir.audiobookapp.R
import com.mudassir.audiobookapp.databinding.AudioBookListFragmentBinding
import com.mudassir.audiobookapp.model.ListenHubAudioBooksModel
import com.mudassir.audiobookapp.ui.bookList.adapter.AudioBookListAdapter
import com.mudassir.audiobookapp.ui.bookList.adapter.ViewBindingAdapters.setProductAdapter
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class AudioBookListFragment : Fragment(),AudioBookListAdapter.Callbacks {

    companion object {
        fun newInstance() = AudioBookListFragment()
    }
    @Inject
    lateinit var viewModelFactory : ViewModelProvider.Factory
    private lateinit var viewModel: AudioBookListViewModel
    private lateinit var mBinding: AudioBookListFragmentBinding
    private lateinit var mAdapter : AudioBookListAdapter
//    val args: AudioBookListFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater,R.layout.audio_book_list_fragment, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        AndroidSupportInjection.inject(this)
        viewModel = ViewModelProviders.of(this,this.viewModelFactory).get(AudioBookListViewModel::class.java)
        mBinding.viewModel= viewModel
        mBinding.onBookItemClicked=this
        mBinding.lifecycleOwner=this
        observeEvents()
    }

    fun observeEvents(){

        viewModel.loading.observe(viewLifecycleOwner, Observer {
            (activity as MainActivity).showProgress(it)
        })

//        viewModel.audioBookList.observe(viewLifecycleOwner, Observer {
//            Timber.d { "list of book ${it.size}" }
//            setProductAdapter(mBinding.rvAudioBooks,it,this)
//        })

    }

    fun setupForRecyclerView(){
//        mAdapter = AudioBookListAdapter(viewMo)
    }

    /***
     *go to details fragment onclick
     ***/
    override fun onBookItemClick(view: View, item: ListenHubAudioBooksModel) {
         Timber.d { "click on book ${item.authors}" }
         val bundle = Bundle()
//        val args = bundleOf("arg" to  item)
        bundle.putParcelable(AppConstants.AUDIO_BOOK_ARGU,item)
        findNavController().navigate(R.id.action_audioBookListFragment_to_bookDetailsFragment,bundle)
//        viewModel.navigationComplete()
    }
}