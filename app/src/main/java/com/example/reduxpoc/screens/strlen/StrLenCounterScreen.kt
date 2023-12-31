package com.example.reduxpoc.screens.strlen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reduxpoc.screens.strlen.store.StrLenCounterUiState

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StrLenCounterScreen(
    state: StrLenCounterUiState,
    onValueUpdated: (String) -> Unit,
    onClearInput: () -> Unit,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            value = state.strFieldValue,
            onValueChange = { newValue ->
                onValueUpdated(newValue)
            })
        Text(text = "String length: ${state.valueLength}")

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { onClearInput() }) {
            Text(text = "Clear input")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun StrLenCounterScreenPreview() {
    StrLenCounterScreen(
        state = StrLenCounterUiState(strFieldValue = "Foo bar", valueLength = 9999),
        onValueUpdated = { _ -> },
        onClearInput = {}
    )
}