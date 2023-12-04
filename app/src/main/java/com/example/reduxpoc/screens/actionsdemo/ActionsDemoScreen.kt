package com.example.reduxpoc.screens.actionsdemo

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.reduxpoc.screens.actionsdemo.feature.ActionsDemoAction
import com.example.reduxpoc.screens.actionsdemo.feature.ActionsDemoUiState

@Composable
fun ActionsDemoScreen(
    state: ActionsDemoUiState,
    onStart: (List<ActionsDemoAction>) -> Unit
) {
    LazyColumn {
        item {
            Button(
                modifier = Modifier.padding(vertical = 16.dp),
                onClick = {
                    onStart(
                        listOf(
                            ActionsDemoAction.EmitMessage(
                                message = "Msg with 3 sec delay",
                                delaySec = 3
                            ),
                            ActionsDemoAction.EmitMessage(
                                message = "Msg with 1 sec delay",
                                delaySec = 1
                            ),
                            ActionsDemoAction.EmitMessage(
                                message = "Msg with 2 sec delay",
                                delaySec = 2
                            )
                        )
                    )
                }
            ) {
                Text(text = "Start actions")
            }
        }
        items(state.messages) { message ->
            Text(text = message)
        }
    }
}