package com.eurosport.mobileapp.ui

import android.os.Bundle
import androidx.annotation.NonNull
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eurosport.mobileapp.R
import com.eurosport.mobileapp.databinding.ActivityMainBinding
import com.eurosport.mobileapp.viewmodels.NewsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
@AndroidEntryPoint
class MainActivity :AppCompatActivity(){
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private lateinit var viewModel:NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel= ViewModelProvider(this,viewModelFactory).get(NewsViewModel::class.java)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel

        //a faire liveData

    }
    override fun onResume() {
        super.onResume()
        viewModel.getNewsFeed()
    }
    override fun onDestroy() {
        super.onDestroy()
        viewModel.unbound()
    }
    override fun onPause() {
        viewModel.clear()
        super.onPause()
    }
    companion object {
        @JvmStatic
        @BindingAdapter("adapter")
        fun bindAlbumsList(@NonNull recyclerView: RecyclerView, viewModel: NewsViewModel) {
            /*val adapter = AlbumsListAdapter(viewModel.newsFeed)
            recyclerView.addItemDecoration(DividerItemDecoration(recyclerView.context, DividerItemDecoration.VERTICAL))
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
            recyclerView.adapter = adapter
        */
        }
    }

}