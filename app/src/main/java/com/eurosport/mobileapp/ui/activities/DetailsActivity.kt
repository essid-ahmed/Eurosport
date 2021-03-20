package com.eurosport.mobileapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.eurosport.domain.models.Story
import com.eurosport.mobileapp.R
import com.eurosport.mobileapp.utils.Constants
import com.joooonho.SelectableRoundedImageView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_details.view.*
import kotlinx.android.synthetic.main.news_item_details.view.*

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        setUpUi(intent.getSerializableExtra(Constants.STORY) as Story)
    }

    private fun setUpUi(story: Story) {
        var imageView  = item_details.item_picture
        imageView.setCornerRadiiDP(0F,0F,0F,0F)
        Picasso.get().load(story.image).into(imageView)
        item_details.title.text = story.title
        item_details.sport.text=story.sport.name
        item_details.author_view.text= getString(R.string.author, story.author, "0 minutes")
        description.text=story.teaser
        back.setOnClickListener { finish() }
    }
}