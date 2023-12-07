package com.example.news99.domain.usecases

import com.example.news99.domain.manager.LocalUserManager
import kotlinx.coroutines.flow.Flow

class ReadAppEntry (
    private val localUserManager: LocalUserManager
) {
   operator fun invoke(): Flow<Boolean> {
        return localUserManager.readAppEntry()
    }
}