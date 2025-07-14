package com.sabcva.app

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "business_profile"
    ) {
        composable("business_profile") {
            BusinessProfileScreen(
                onBackClick = { /* Handle back if needed */ },
                onShareClick = { /* Handle share */ }
            )
        }
        composable("business") { BusinessProfileScreen() }
        composable("profile") { ProfileScreen() }
    }
}