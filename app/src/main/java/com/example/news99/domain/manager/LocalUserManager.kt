package com.example.news99.domain.manager

import kotlinx.coroutines.flow.Flow


interface LocalUserManager {

    suspend fun saveAppEntry()

    fun readAppEntry():Flow<Boolean>
}