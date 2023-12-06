package com.example.news99.presentation.onboarding

import androidx.annotation.DrawableRes
import com.example.news99.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "lorem ipsum is a dummy",
        "baka baka dummy dummy for the news99",
        R.drawable.onboarding1
    ),
    Page(
        "lorem ipsum is a dummy",
        "baka baka dummy dummy for the news99",
        R.drawable.onboarding2
    ),
    Page(
        "lorem ipsum is a dummy",
        "baka baka dummy dummy for the news99",
        R.drawable.onboarding3
    )
)