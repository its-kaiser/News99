package com.example.news99.presentation.favourite

import androidx.lifecycle.ViewModel
import com.example.news99.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {
}