package com.example.reduxpoc.screens.strlen.store

import com.example.reduxpoc.arch.Action
import com.example.reduxpoc.arch.Effect
import com.example.reduxpoc.arch.Store
import com.example.reduxpoc.arch.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow

class StrLenCounterStore(
    coroutineScope: CoroutineScope,
    actor: StrLenCounterActor,
    reducer: StrLenCounterReducer,
) : Store<StrLenCounterUiState, StrLenCounterAction, StrLenCounterEffect>(
    coroutineScope, actor, reducer
) {

    override val stateFlowInternal = MutableStateFlow(StrLenCounterUiState.INITIAL)
}

data class StrLenCounterUiState(
    val strFieldValue: String,
    val valueLength: Int
) : UiState {
    companion object {
        val INITIAL = StrLenCounterUiState(strFieldValue = "", valueLength = 0)
    }
}

sealed class StrLenCounterAction : Action {
    data class UpdateInput(val strFieldValue: String) : StrLenCounterAction()
    object ClearInput : StrLenCounterAction()
}

sealed class StrLenCounterEffect : Effect {

    data class ValueUpdated(val updatedValue: String, val length: Int) : StrLenCounterEffect()
}