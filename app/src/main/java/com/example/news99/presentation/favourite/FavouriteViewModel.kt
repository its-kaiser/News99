package com.example.news99.presentation.favourite

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news99.domain.usecases.news.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class FavouriteViewModel @Inject constructor(
    private val newsUseCases: NewsUseCases
): ViewModel() {

    private val _state = mutableStateOf(FavouriteState())
    val state : State<FavouriteState> = _state


    init {
        getArticles()
    }
    private fun getArticles(){
        newsUseCases.selectArticles().onEach {
            _state.value = _state.value.copy(articles = it)
        }.launchIn(viewModelScope)
    }
}