package com.sbz.zennotes.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {

}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(
        modifier = Modifier.padding(26.dp),
        navController = rememberNavController()
    )
}