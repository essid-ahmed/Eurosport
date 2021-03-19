package com.eurosport.mobileapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.eurosport.domain.models.News
import com.eurosport.mobileapp.utils.ObservableRecyclerViewAdapter
import com.jommaa.domain.model.Album
import com.jommaa.leboncoin.databinding.ListItemAlbumBinding
import com.jommaa.leboncoin.utils.ObservableRecyclerViewAdapter
import com.squareup.picasso.Picasso

class NewsListAdapter(albums: ObservableList<News>) : ObservableRecyclerViewAdapter<News, NewsListAdapter.Holder>(albums) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ListItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(getItem(position))
    }

    class Holder(
        private val binding: ListItemAlbumBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private lateinit var album: Album

        fun bind(album: Album) {
            this.album = album

            Picasso.get().load(album.thumbnailUrl).into(binding.image)
            binding.name.text = album.title
        }
    }
}