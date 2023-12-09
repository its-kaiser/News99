package com.example.news99.presentation.favourite

import com.example.news99.domain.model.Article

data class FavouriteState(
    val articles :List<Article> = emptyList()
)
