package com.example.reduxpoc.navigation

import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.reduxpoc.screens.strlen.StrLenCounterScreen
import com.example.reduxpoc.screens.strlen.StrLenCounterViewModel
import com.example.reduxpoc.screens.strlen.store.StrLenCounterAction
import com.example.reduxpoc.screens.strlen.store.StrLenCounterUiState
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.strLenCounter() {
    composable(route = Destination.StrLenCounter.route) {
        val screenViewModel: StrLenCounterViewModel = koinViewModel()

        val state: StrLenCounterUiState by screenViewModel.uiState.collectAsStateWithLifecycle(
            initialValue = StrLenCounterUiState.INITIAL
        )
        StrLenCounterScreen(
            state = state,
            onValueUpdated = { newValue ->
                screenViewModel.dispatch(
                    StrLenCounterAction.UpdateInput(newValue)
                )
            },
            onClearInput = {
                screenViewModel.dispatch(StrLenCounterAction.ClearInput)
            }
        )
    }
}