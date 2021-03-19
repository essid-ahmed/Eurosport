package com.eurosport.mobileapp.viewmodels

import androidx.databinding.ObservableArrayList
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.eurosport.domain.models.News
import com.eurosport.domain.result.NewsResult
import com.eurosport.domain.usecase.GetNewsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

open class NewsViewModel @Inject constructor(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {

    val news = ObservableArrayList<News>()
    val disposables = CompositeDisposable()
    var  progressVisible = ObservableBoolean()
    var emptyMessageVisible = ObservableBoolean()
    fun getNewsFeed()  {
        getNewsUseCase.execute().
            subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { handleNewsReception(it) }
            .addTo(disposables)
    }

    fun unbound() {
        disposables.clear()
    }

    fun clear(){
        disposables.clear()
    }

    private fun handleNewsReception(result:NewsResult) {
      progressVisible.set( true)
      emptyMessageVisible.set(false)
      when (result){
         is NewsResult.Success ->{
             news.addAll(result.newsList)
             emptyMessageVisible.set( false)
             progressVisible.set(false)
          }
          is NewsResult.Failure -> {
              emptyMessageVisible.set( true)
              progressVisible.set(false)
          }
      }
    }



}