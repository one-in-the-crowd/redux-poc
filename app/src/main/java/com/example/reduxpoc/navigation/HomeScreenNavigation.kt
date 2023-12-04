package com.example.reduxpoc.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.reduxpoc.screens.home.HomeScreen
import com.example.reduxpoc.screens.home.HomeScreenViewModel
import com.example.reduxpoc.screens.home.feature.HomeUiState
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.homeScreen(
    navController: NavHostController
) {
    composable(route = Destination.Home.route) {
        val screenViewModel: HomeScreenViewModel = koinViewModel()

        val state: HomeUiState by screenViewModel.uiState.collectAsStateWithLifecycle(
            initialValue = HomeUiState()
        )
        HomeScreen(
            state = state,
            navController = navController,
            onNavigationClicked = { action ->
                screenViewModel.dispatch(action)
            }
        )
    }
}