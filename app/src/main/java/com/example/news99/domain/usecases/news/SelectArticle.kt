package com.example.news99.domain.usecases.news

import com.example.news99.data.local.NewsDao
import com.example.news99.domain.model.Article

class SelectArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(url: String):Article?{
        return newsDao.getArticle(url)
    }
}