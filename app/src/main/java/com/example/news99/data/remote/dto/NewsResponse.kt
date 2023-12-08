package com.example.news99.data.remote.dto

import com.example.news99.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)