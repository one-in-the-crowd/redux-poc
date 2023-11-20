package com.example.reduxpoc.screens.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.reduxpoc.ui.theme.ReduxPOCTheme

@Composable
fun HomeScreen() {
    ReduxPOCTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Text(text = "Home screen")
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen()
}