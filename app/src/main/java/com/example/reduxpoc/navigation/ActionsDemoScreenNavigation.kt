package com.example.reduxpoc.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.reduxpoc.screens.actionsdemo.ActionsDemoScreen
import com.example.reduxpoc.screens.actionsdemo.ActionsDemoViewModel
import com.example.reduxpoc.screens.actionsdemo.store.ActionsDemoUiState
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.actionsDemoScreen() {
    composable(route = Destination.ActionsDemo.route) {
        val screenViewModel: ActionsDemoViewModel = koinViewModel()

        val state: ActionsDemoUiState by screenViewModel.uiState.collectAsStateWithLifecycle(
            initialValue = ActionsDemoUiState()
        )
        ActionsDemoScreen(
            state = state,
            onStart = { actionsToDispatch ->
                actionsToDispatch.forEach(screenViewModel::dispatch)
            }
        )
    }
}