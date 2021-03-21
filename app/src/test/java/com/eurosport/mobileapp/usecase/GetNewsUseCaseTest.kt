package com.eurosport.mobileapp.usecase


import com.eurosport.domain.models.News
import com.eurosport.domain.models.NewsFeed
import com.eurosport.domain.models.Story
import com.eurosport.domain.models.Video
import com.eurosport.domain.repository.INewsRepository
import com.eurosport.domain.result.NewsResult
import com.eurosport.domain.usecase.GetNewsUseCase
import com.eurosport.mobileapp.rx.RxJavaTestHooksResetRule
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify

import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class GetNewsUseCaseTest {
  @get:Rule
  var rxJavaTestHooksResetRule = RxJavaTestHooksResetRule()

  @Mock
  lateinit var iNewsRepository: INewsRepository

  private lateinit var sut: GetNewsUseCase

  @Before
  fun setUp() {
    sut = GetNewsUseCase(iNewsRepository)
  }

  @Test
  fun `retrieves the newsFeed`() {
    given(iNewsRepository.getNewsFeed()).willReturn(Single.error(Throwable()))

    sut.execute().test()

    verify(iNewsRepository).getNewsFeed()
  }

  @Test
  fun `shows loading to start`() {
    given(iNewsRepository.getNewsFeed()).willReturn(Single.just(mock()))

    sut.execute().test().assertValueAt(0) { (it == NewsResult.Loading) }
  }

  @Test
  fun `returns the success result when success retrieving the newsFeed`() {
    val videosList = arrayListOf<Video>()
    val storiesList = arrayListOf<Story>()
    val newsList = arrayListOf<News>()
    newsList.addAll(videosList)
    newsList.addAll(storiesList)
    val newsFeed=NewsFeed(videosList,storiesList)
    given(iNewsRepository.getNewsFeed()).willReturn(Single.just(newsFeed))

    sut.execute().test()
      .assertValueAt(1) { (it as NewsResult.Success).newsList == newsList}
  }

  @Test
  fun `returns the failure result when error retrieving the videos and stories list`() {
    val throwable = Throwable()
    val videosList = arrayListOf<Video>()
    val storiesList = arrayListOf<Story>()
    val newsList = arrayListOf<News>()
    newsList.addAll(videosList)
    newsList.addAll(storiesList)

    val newsFeed=NewsFeed(videosList,storiesList)
    given(iNewsRepository.getNewsFeed()).willReturn(Single.error(throwable))
    given(iNewsRepository.getLocalNewsFeed()).willReturn(newsFeed)

    sut.execute().test().assertValueAt(1){(it as NewsResult.Success).newsList==newsList}
  }
}