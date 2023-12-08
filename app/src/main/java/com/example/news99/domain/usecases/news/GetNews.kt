package com.example.news99.domain.usecases.news

import androidx.paging.PagingData
import com.example.news99.domain.model.Article
import com.example.news99.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources:List<String>):Flow<PagingData<Article>> {
        return newsRepository.getNews(sources=sources)
    }
}