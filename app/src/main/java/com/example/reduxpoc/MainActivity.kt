package com.example.reduxpoc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.reduxpoc.screens.home.HomeUiState
import com.example.reduxpoc.screens.home.HomeScreen
import com.example.reduxpoc.screens.home.HomeScreenViewModel
import com.example.reduxpoc.screens.strlen.StrLenCounterScreen
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
                        navController = navController, startDestination = Destination.Home.route
                    ) {
                        composable(route = Destination.Home.route) {
                            val homeVm: HomeScreenViewModel = koinViewModel()

                            // TODO use collectAsStateWithLifecycle()
                            val state: HomeUiState by homeVm.uiState.collectAsState(initial = HomeUiState())
                            HomeScreen(
                                state = state,
                                navController = navController,
                                onNavigationClicked = { action ->
                                    homeVm.dispatch(action)
                                }
                            )
                        }
                        composable(route = Destination.StrLenCounter.route) {
                            StrLenCounterScreen()
                        }
                    }
                }
            }

        }
    }
}
