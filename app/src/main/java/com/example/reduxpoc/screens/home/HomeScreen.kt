package com.example.reduxpoc.screens.home

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
import com.example.reduxpoc.Destination
import com.example.reduxpoc.screens.home.feature.HomeAction
import com.example.reduxpoc.screens.home.feature.HomeUiState

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
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Button(onClick = {
                onNavigationClicked(
                    HomeAction.NavigateStrLen { navController.navigate(Destination.StrLenCounter.route) }
                )
            }) {
                Text(text = "String length checker")
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(HomeUiState(), rememberNavController()) { _ -> }
}