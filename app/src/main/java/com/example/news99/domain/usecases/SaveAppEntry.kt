package com.example.news99.domain.usecases

import com.example.news99.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager:LocalUserManager
) {
    suspend operator fun invoke(){
        localUserManager.saveAppEntry()
    }
}