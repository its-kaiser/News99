package com.example.news99.domain.usecases.news

import com.example.news99.data.local.NewsDao
import com.example.news99.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsDao: NewsDao
) {

     operator fun invoke():Flow<List<Article>>{
        return newsDao.getArticles()
    }
}