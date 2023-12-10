package com.example.news99

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.example.news99.presentation.news_navigator.NewsNavigator
import com.example.news99.ui.theme.News99Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        //splash screen will be visible until start destination has been fetched
        installSplashScreen()
            //.apply {
            //setKeepOnScreenCondition{
              //  viewModel.splashCondition.value
            //}
        //}

        setContent {
            News99Theme(dynamicColor = false) {

                Surface(modifier = Modifier.background(MaterialTheme.colorScheme.background)) {
                    //val startDestination = viewModel.startDestination.value
                    //NavGraph(startDestination = startDestination)

                    NewsNavigator()
                }
            }
        }
    }
}