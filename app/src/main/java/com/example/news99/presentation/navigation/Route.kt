package com.example.news99.presentation.navigation

sealed class Route(
    val route :String
) {

    object OnBoardingScreen: Route("onBoardingScreen")
    object HomeScreen: Route("homeScreen")
    object SearchScreen: Route("searchScreen")
    object FavoritesScreen: Route("favoritesScreen")
    object DetailsScreen: Route("detailsScreen")
    object AppStartNavigation: Route("appStartNavigation")
    object NewsNavigation: Route("newsNavigation")
    object NewsNavigatorScreen: Route("newsNavigatorScreen")

}