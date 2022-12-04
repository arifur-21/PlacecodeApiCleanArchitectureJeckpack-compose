package com.example.placeholderapicleanarchitecture.di

import android.app.Application
import com.example.placeholderapicleanarchitecture.common.Constants
import com.example.placeholderapicleanarchitecture.data.remote.JsonApi
import com.example.placeholderapicleanarchitecture.data.repository.JsonRepositoryImpl
import com.example.placeholderapicleanarchitecture.domain.repository.JsonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModul {

    @Provides
    @Singleton
    fun provideJsonApi(app: Application): JsonApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JsonApi::class.java)
    }

    @Provides
    @Singleton
    fun provideJsonRepository(api: JsonApi): JsonRepository{
     return JsonRepositoryImpl(api)
    }
}