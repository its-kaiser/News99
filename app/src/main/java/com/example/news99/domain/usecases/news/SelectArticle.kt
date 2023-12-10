package com.example.news99.domain.usecases.news

import com.example.news99.domain.model.Article
import com.example.news99.domain.repository.NewsRepository

class SelectArticle (
    private val newsRepository: NewsRepository
) {

    suspend operator fun invoke(url: String):Article?{
        return newsRepository.selectArticle(url)
    }
}