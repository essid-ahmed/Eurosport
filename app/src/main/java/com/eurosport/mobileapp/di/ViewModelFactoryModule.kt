package com.eurosport.mobileapp.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eurosport.mobileapp.di.annotation.ViewModelKey
import com.eurosport.mobileapp.factory.ViewModelFactory
import com.eurosport.mobileapp.viewmodels.NewsViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
abstract class ViewModelFactoryModule {

    @Binds
    @Singleton
   abstract fun providesViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    abstract fun bindViewModel(viewModel: NewsViewModel): ViewModel


}