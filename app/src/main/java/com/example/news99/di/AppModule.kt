package com.example.news99.di

import android.app.Application
import androidx.room.Room
import com.example.news99.data.local.NewsDao
import com.example.news99.data.local.NewsDatabase
import com.example.news99.data.local.NewsTypeConverter
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
import com.example.news99.utils.Constants.NEWS_DATABASE_NAME
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


    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ):NewsDatabase{
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConverter())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ):NewsDao = newsDatabase.newsDao
}