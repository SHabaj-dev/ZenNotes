package com.sbz.zennotes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sbz.zennotes.ui.screens.AddEdit
import com.sbz.zennotes.ui.screens.MainScreen
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

        composable("main_screen") {
            MainScreen(modifier = modifier, navController = navController)
        }

        composable("add_edit") {
            AddEdit(modifier = modifier, navController = navController)
        }

    }


}