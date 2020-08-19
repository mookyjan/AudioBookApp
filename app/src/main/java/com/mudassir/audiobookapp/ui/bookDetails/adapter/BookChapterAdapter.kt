package com.mudassir.audiobookapp.ui.bookDetails.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.github.ajalt.timberkt.Timber
import com.mudassir.audiobookapp.R
import com.mudassir.audiobookapp.databinding.SingleItemChapterBinding
import com.mudassir.audiobookapp.model.Chapters

class BookChapterAdapter (private val chaptersList : List<Chapters>, private val callbacks: Callbacks? = null): RecyclerView.Adapter<BookChapterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Timber.d { "chapters list $chaptersList" }
        val inflater = LayoutInflater.from(parent.context)
        val binding: SingleItemChapterBinding =
            DataBindingUtil.inflate(inflater, R.layout.single_item_chapter, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return chaptersList.size;
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.item = chaptersList.get(position)
        holder.binding.executePendingBindings()
    }

    interface Callbacks {
        fun onBookItemClick(view: View, item: Chapters)
    }

    inner class ViewHolder(val binding: SingleItemChapterBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            itemView.setOnClickListener {
                callbacks?.onBookItemClick(
                    it,
                    chaptersList!!.get(adapterPosition)
                )
            }
        }
    }
}