package com.example.news99.presentation.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.news99.presentation.onboarding.OnBoardingScreen
import com.example.news99.presentation.onboarding.OnBoardingViewModel


@Composable
fun NavGraph(
    startDestination: String
){
    val naveController = rememberNavController()
    
    NavHost(navController = naveController, startDestination = startDestination){
        navigation(
            route=Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ){
            composable(route= Route.OnBoardingScreen.route){
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(
                    event = viewModel::onEvent
                )
            }
        }
        navigation(
            route= Route.NewsNavigation.route,
            startDestination = Route.HomeScreen.route
        ){
            composable(route= Route.HomeScreen.route){
                Text(text = "News Navigator Screen")
            }
        }
    }
}