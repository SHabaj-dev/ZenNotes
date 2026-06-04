package com.sbz.zennotes.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: ImageVector
) {


    object Home : BottomNavItem(
        route = "home",
        title = "Home",
        icon = Icons.Rounded.Home
    )

    object Favorites : BottomNavItem(
        route = "favorites",
        title = "Favorites",
        icon = Icons.Rounded.Star
    )

    object Settings : BottomNavItem(
        route = "settings",
        title = "Settings",
        icon = Icons.Rounded.Settings
    )

}