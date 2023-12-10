package com.example.news99.domain.usecases.news

import com.example.news99.domain.model.Article
import com.example.news99.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles (
    private val newsRepository: NewsRepository
) {

     operator fun invoke():Flow<List<Article>>{
        return newsRepository.selectArticles()
    }
}