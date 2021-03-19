package com.eurosport.mobileapp.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import com.eurosport.domain.models.News
import com.eurosport.domain.models.Story
import com.eurosport.domain.models.Video
import com.eurosport.mobileapp.R
import com.eurosport.mobileapp.databinding.NewsItemBinding
import com.eurosport.mobileapp.ui.activities.EuroSportPlayerActivity
import com.eurosport.mobileapp.utils.DateUtils
import com.eurosport.mobileapp.utils.ObservableRecyclerViewAdapter
import com.squareup.picasso.Picasso


class NewsListAdapter(val context: Context, news: ObservableList<News>) : ObservableRecyclerViewAdapter<News, NewsListAdapter.Holder>(news) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(context,
                NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val news =getItem(position)
        if (news.isVideo())
        {
            holder.bindVideo(news as Video)
        }
        else
        {
            holder.binStory(news as Story)
        }
        holder.binding.parentLayout.setOnClickListener(View.OnClickListener {
            if (news.isVideo())
                {
                    var intent =Intent(context, EuroSportPlayerActivity::class.java)
                    val video =news as Video
                    if(video.url!=null)
                    {
                        intent.putExtra("URL",video.url)
                        context.startActivity(intent)
                    }
            }
        })

    }

    class Holder(private val context: Context, val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private fun bindCommonAttributes(news: News)
        {
            binding.title.text = news.title
            binding.sport.text=news.sport.name
        }

        fun bindVideo(video: Video)
        {

            binding.play.visibility=View.VISIBLE
            bindCommonAttributes(video)
            binding.authorView.text=  context.getString(R.string.views, video.views)
            Picasso.get().load(video.thumb).into(binding.itemPicture)
        }

        fun binStory(story: Story)
        {
            binding.play.visibility=View.GONE
            bindCommonAttributes(story)
            var dateDifference = DateUtils.getDif(context, story.date)

            binding.authorView.text= context.getString(R.string.author, story.author, dateDifference)
         Picasso.get().load(story.image).into(binding.itemPicture)
        }
    }
}