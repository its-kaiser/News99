package com.example.news99.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.news99.data.remote.NewsApi
import com.example.news99.data.remote.NewsPagingSource
import com.example.news99.domain.model.Article
import com.example.news99.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImplementation(
    private val newsApi: NewsApi
):NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(
                    newsApi=newsApi,
                    sources= sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

}