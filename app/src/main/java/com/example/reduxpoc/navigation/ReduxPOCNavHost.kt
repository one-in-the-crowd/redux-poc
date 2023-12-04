package com.example.reduxpoc.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController

@Composable
fun ReduxPOCNavHost(
    startDestination: String = Destination.Home.route
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        homeScreen(navController)
        strLenCounter()
        actionsDemoScreen()
    }
}