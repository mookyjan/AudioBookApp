package com.mudassir.audiobookapp.ui.bookList

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mudassir.audiobookapp.R
import com.mudassir.audiobookapp.databinding.AudioBookListFragmentBinding

class AudioBookListFragment : Fragment() {

    companion object {
        fun newInstance() = AudioBookListFragment()
    }

    private lateinit var viewModel: AudioBookListViewModel
    private lateinit var mBinding: AudioBookListFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        mBinding = DataBindingUtil.inflate(inflater,R.layout.audio_book_list_fragment, container, false)
        return mBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AudioBookListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}