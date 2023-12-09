package com.example.news99.domain.usecases.news

import com.example.news99.data.local.NewsDao
import com.example.news99.domain.model.Article

class DeleteArticle (
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article){
        newsDao.delete(article)
    }
}