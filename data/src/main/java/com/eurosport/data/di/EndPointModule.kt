package com.eurosport.data.di

import com.eurosport.data.api.EndPoint
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object EndPointModule {

    @Singleton
    @Provides
    fun providesEndPointModule(retrofit: Retrofit): EndPoint {
        return retrofit.create(EndPoint::class.java)
    }
}