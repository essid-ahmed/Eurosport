package com.eurosport.data.di
import com.eurosport.data.repositoryImp.NewsRepositoryImp
import com.eurosport.domain.repository.INewsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class  RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindNewsFeedRepository(newsRepositoryImp: NewsRepositoryImp): INewsRepository
}




