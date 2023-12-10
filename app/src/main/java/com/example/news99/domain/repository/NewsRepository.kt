package com.example.news99.domain.repository

import androidx.paging.PagingData
import com.example.news99.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String,sources: List<String>): Flow<PagingData<Article>>

    suspend fun upsertArticle(article: Article)

    suspend fun deleteArticle(article:Article)

    fun selectArticles(): Flow<List<Article>>

    suspend fun selectArticle(url:String):Article?
}