package com.mudassir.audiobookapp.ui.bookList.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.ajalt.timberkt.Timber
import com.mudassir.audiobookapp.R
import com.mudassir.audiobookapp.databinding.SingleItemAudioBookBinding
import com.mudassir.audiobookapp.model.ListenHubAudioBooksModel

class AudioBookListAdapter (): RecyclerView.Adapter<AudioBookListAdapter.ViewHolder>() {


    var audioBookList = listOf<ListenHubAudioBooksModel>()
    private var callbacks: Callbacks? = null

    fun setData(list: List<ListenHubAudioBooksModel>){
        audioBookList =list
    }
    fun setupListener(listener: Callbacks?){
        this.callbacks=listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Timber.d { "audio book list $audioBookList" }
        val inflater = LayoutInflater.from(parent.context)
        val binding: SingleItemAudioBookBinding =
            DataBindingUtil.inflate(inflater, R.layout.single_item_audio_book, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return audioBookList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = audioBookList.get(position)
        holder.binding.txtSerialNo.text =(position+1).toString()
        holder.binding.executePendingBindings()
    }

    interface Callbacks {
        fun onBookItemClick(view: View, item: ListenHubAudioBooksModel)
    }

    inner class ViewHolder(val binding: SingleItemAudioBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {

            itemView.setOnClickListener {
                callbacks?.onBookItemClick(
                    it,
                    audioBookList!!.get(adapterPosition)
                )
            }
        }
    }
}
