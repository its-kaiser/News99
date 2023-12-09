package com.example.news99.presentation.details

import com.example.news99.domain.model.Article

sealed class DetailsEvent {

    data class UpsertDeleteArticle(val article: Article):DetailsEvent()

    object RemoveSideEffect : DetailsEvent()
}