package com.example.news99.presentation.search

import androidx.paging.PagingData
import com.example.news99.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery:String ="",
    val articles : Flow<PagingData<Article>>? = null
) {
}