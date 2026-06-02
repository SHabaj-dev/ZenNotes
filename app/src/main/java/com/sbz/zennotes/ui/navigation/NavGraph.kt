package com.sbz.zennotes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sbz.zennotes.ui.screens.HomeScreen
import com.sbz.zennotes.ui.screens.onboarding.Onboarding
import com.sbz.zennotes.ui.screens.onboarding.SplashScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        composable("splash") {
            SplashScreen(
                modifier = modifier,
                navController = navController
            )
        }

        composable("onboarding") {
            Onboarding(modifier = modifier, navController = navController)
        }

        composable("home") {
            HomeScreen(modifier = modifier, navController = navController)
        }

    }


}