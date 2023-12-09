package com.example.news99.di

import android.app.Application
import com.example.news99.data.manager.LocalUserManagerImplementation
import com.example.news99.data.remote.NewsApi
import com.example.news99.data.repository.NewsRepositoryImplementation
import com.example.news99.domain.manager.LocalUserManager
import com.example.news99.domain.repository.NewsRepository
import com.example.news99.domain.usecases.appentry.AppEntryUseCases
import com.example.news99.domain.usecases.appentry.ReadAppEntry
import com.example.news99.domain.usecases.appentry.SaveAppEntry
import com.example.news99.domain.usecases.news.GetNews
import com.example.news99.domain.usecases.news.NewsUseCases
import com.example.news99.domain.usecases.news.SearchNews
import com.example.news99.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManager(
        application: Application
    ):LocalUserManager=LocalUserManagerImplementation(application)

    @Provides
    @Singleton
    fun provideAppEntryUSeCases(
        localUserManager: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManager),
        saveAppEntry = SaveAppEntry(localUserManager)
    )

    @Provides
    @Singleton
    fun provideNewsApi(): NewsApi{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }
    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ):NewsRepository = NewsRepositoryImplementation(newsApi)

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }
}