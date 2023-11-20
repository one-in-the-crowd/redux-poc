package com.example.reduxpoc.screens.strlen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun StringLengthCounter() {
    var stringLength by remember { mutableIntStateOf(0) }
    var textFieldValue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        TextField(modifier = Modifier, value = textFieldValue, onValueChange = {
            textFieldValue = it
            stringLength = textFieldValue.length
        })
        Text(text = "String length: $stringLength")
    }
}

@Preview
@Composable
private fun StringLengthCounterPreview() {
    StringLengthCounter()
}