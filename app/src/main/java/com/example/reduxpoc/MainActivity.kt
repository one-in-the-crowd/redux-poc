package com.example.reduxpoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reduxpoc.screens.actionsdemo.ActionsDemoScreen
import com.example.reduxpoc.screens.actionsdemo.feature.ActionsDemoUiState
import com.example.reduxpoc.screens.actionsdemo.feature.ActionsDemoViewModel
import com.example.reduxpoc.screens.home.HomeScreen
import com.example.reduxpoc.screens.home.HomeScreenViewModel
import com.example.reduxpoc.screens.home.feature.HomeUiState
import com.example.reduxpoc.screens.strlen.StrLenCounterScreen
import com.example.reduxpoc.screens.strlen.StrLenCounterViewModel
import com.example.reduxpoc.screens.strlen.feature.StrLenCounterAction
import com.example.reduxpoc.screens.strlen.feature.StrLenCounterUiState
import com.example.reduxpoc.ui.theme.ReduxPOCTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            ReduxPOCTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Destination.Home.route
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
                }
            }

        }
    }
}
