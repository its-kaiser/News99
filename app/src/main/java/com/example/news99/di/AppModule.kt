package com.example.news99.di

import android.app.Application
import com.example.news99.data.manager.LocalUserManagerImplementation
import com.example.news99.domain.manager.LocalUserManager
import com.example.news99.domain.usecases.appentry.AppEntryUseCases
import com.example.news99.domain.usecases.appentry.ReadAppEntry
import com.example.news99.domain.usecases.appentry.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}