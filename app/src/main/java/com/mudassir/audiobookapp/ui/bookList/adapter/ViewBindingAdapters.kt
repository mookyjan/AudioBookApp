package com.mudassir.audiobookapp.ui.bookList.adapter

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mudassir.audiobookapp.model.ListenHubAudioBooksModel

object ViewBindingAdapters {

    @JvmStatic
    @BindingAdapter("bookListAdapter", "bookListCallbacks", requireAll = false)
    fun setBookAdapter(recyclerView: RecyclerView, items: List<ListenHubAudioBooksModel>?, callbacks: AudioBookListAdapter.Callbacks?) {
        items?.let {
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = AudioBookListAdapter(callbacks)
        }
    }
}