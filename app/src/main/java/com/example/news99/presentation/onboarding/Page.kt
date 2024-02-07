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
        "Timely Insights, Timeless Class",
        "Elevate Your Awareness with Instant News",
        R.drawable.onboard1
    ),
    Page(
        "Unraveling Markets",
        " Navigating the Ebb and Flow of Stocks – Stay Informed, Invest Smart.",
        R.drawable.onboard2
    ),
    Page(
        "Elevate Your Sporting Insight",
        "Where Every Score, Triumph, and Defeat Finds Its Spotlight in Sports News Excellence!",
        R.drawable.onboard3
    )
)