package com.example.reduxpoc.screens.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.reduxpoc.navigation.Destination
import com.example.reduxpoc.screens.home.store.HomeAction
import com.example.reduxpoc.screens.home.store.HomeUiState

@Composable
fun HomeScreen(
    state: HomeUiState,
    navController: NavHostController,
    onNavigationClicked: (HomeAction) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp)
    ) {
        Text(text = "Home screen")
        Column(
            modifier = Modifier.padding(top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Button(onClick = {
                onNavigationClicked(
                    HomeAction.NavigateStrLen { navController.navigate(Destination.StrLenCounter.route) }
                )
            }) {
                Text(text = "String length checker")
            }

            Button(onClick = {
                onNavigationClicked(
                    HomeAction.NavigateStrLen { navController.navigate(Destination.ActionsDemo.route) }
                )
            }) {
                Text(text = "Actions demo")
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(HomeUiState(), rememberNavController()) { _ -> }
}