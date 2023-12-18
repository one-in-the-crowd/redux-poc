package com.example.reduxpoc.screens.strlen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reduxpoc.screens.strlen.store.StrLenCounterAction
import com.example.reduxpoc.screens.strlen.store.StrLenCounterActor
import com.example.reduxpoc.screens.strlen.store.StrLenCounterStore
import com.example.reduxpoc.screens.strlen.store.StrLenCounterReducer
import com.example.reduxpoc.screens.strlen.store.StrLenCounterUiState
import kotlinx.coroutines.flow.Flow

class StrLenCounterViewModel(
    actor: StrLenCounterActor,
    reducer: StrLenCounterReducer
) : ViewModel() {
    private val store: StrLenCounterStore = StrLenCounterStore(viewModelScope, actor, reducer)

    val uiState: Flow<StrLenCounterUiState> = store.uiState
    fun dispatch(action: StrLenCounterAction) = store.dispatch(action)
}