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
import com.eurosport.mobileapp.ui.activities.DetailsActivity
import com.eurosport.mobileapp.ui.activities.EuroSportPlayerActivity
import com.eurosport.mobileapp.utils.Constants
import com.eurosport.mobileapp.utils.DateUtils
import com.eurosport.mobileapp.utils.ObservableRecyclerViewAdapter
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.news_item_details.view.*


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
                        intent.putExtra(Constants.URL,video.url)
                        context.startActivity(intent)
                    }
            }
            else
            {
                var intent =Intent(context, DetailsActivity::class.java)
                val story =news as Story
                intent.putExtra(Constants.STORY,story)
                context.startActivity(intent)

            }
        })

    }

    class Holder(private val context: Context, val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        private fun bindCommonAttributes(news: News)
        {
            binding.details.title.text = news.title
            binding.details.sport.text=news.sport.name
        }

        fun bindVideo(video: Video)
        {

            binding.details.play.visibility=View.VISIBLE
            bindCommonAttributes(video)
            binding.details.author_view.text=  context.getString(R.string.views, video.views)
            Picasso.get().load(video.thumb).into(binding.details.item_picture)
        }

        fun binStory(story: Story)
        {
            binding.details.play.visibility=View.GONE
            bindCommonAttributes(story)
            var dateDifference = DateUtils.getDif(context, story.date)

            binding.details.author_view.text= context.getString(R.string.author, story.author, dateDifference)
             Picasso.get().load(story.image).into(binding.details.item_picture)
        }
    }
}