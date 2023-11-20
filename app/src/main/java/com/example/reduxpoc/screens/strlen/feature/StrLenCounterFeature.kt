package com.example.reduxpoc.screens.strlen.feature

import com.example.reduxpoc.arch.Action
import com.example.reduxpoc.arch.Effect
import com.example.reduxpoc.arch.Feature
import com.example.reduxpoc.arch.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch

class StrLenCounterFeature(
    private val coroutineScope: CoroutineScope,
    private val actor: StrLenCounterActor,
    private val reducer: StrLenCounterReducer,
) : Feature<StrLenCounterUiState, StrLenCounterAction>() {

    private val _uiState: MutableStateFlow<StrLenCounterUiState> =
        MutableStateFlow(StrLenCounterUiState.INITIAL)
    override val uiState: Flow<StrLenCounterUiState> = _uiState

    override fun dispatch(action: StrLenCounterAction) {
        // TODO this should be a flow
        coroutineScope.launch {
            val effect = actor.handle(action)
            if (effect != null) {
                _uiState.getAndUpdate { currentState ->
                    reducer.reduce(currentState, effect)
                }
            }
        }
    }
}

data class StrLenCounterUiState(
    val strFieldValue: String,
    val valueLength: Int
) : UiState {

    companion object {
        val INITIAL = StrLenCounterUiState("", 0)
    }
}

sealed class StrLenCounterAction : Action {
    data class UpdateInput(val strFieldValue: String) : StrLenCounterAction()
}

sealed class StrLenCounterEffect : Effect {

    data class ValueUpdated(val updatedValue: String, val length: Int) : StrLenCounterEffect()
}