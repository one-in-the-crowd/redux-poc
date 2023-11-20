package com.example.reduxpoc.screens.strlen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reduxpoc.screens.strlen.feature.StrLenCounterAction
import com.example.reduxpoc.screens.strlen.feature.StrLenCounterActor
import com.example.reduxpoc.screens.strlen.feature.StrLenCounterFeature
import com.example.reduxpoc.screens.strlen.feature.StrLenCounterReducer
import com.example.reduxpoc.screens.strlen.feature.StrLenCounterUiState
import kotlinx.coroutines.flow.Flow

class StrLenCounterViewModel(
    actor: StrLenCounterActor,
    reducer: StrLenCounterReducer
) : ViewModel() {
    private val feature: StrLenCounterFeature = StrLenCounterFeature(viewModelScope, actor, reducer)

    val uiState: Flow<StrLenCounterUiState> = feature.uiState
    fun dispatch(action: StrLenCounterAction) = feature.dispatch(action)
}