package com.example.news99.presentation.search

import androidx.lifecycle.ViewModel
import com.example.news99.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
):ViewModel() {
}