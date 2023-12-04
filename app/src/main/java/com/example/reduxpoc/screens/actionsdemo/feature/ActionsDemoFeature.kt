package com.example.reduxpoc.screens.actionsdemo.feature

import com.example.reduxpoc.arch.Action
import com.example.reduxpoc.arch.Effect
import com.example.reduxpoc.arch.Feature
import com.example.reduxpoc.arch.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow

class ActionsDemoFeature(
    coroutineScope: CoroutineScope, actor: ActionsDemoActor, reducer: ActionsDemoReducer
) : Feature<ActionsDemoUiState, ActionsDemoAction, ActionsDemoEffect>(
    coroutineScope, actor, reducer
) {
    override val stateFlowInternal = MutableStateFlow(ActionsDemoUiState.INITIAL_STATE)
}

data class ActionsDemoUiState(
    val messages: List<String> = emptyList()
) : UiState {
    companion object {
        val INITIAL_STATE = ActionsDemoUiState()
    }
}

sealed class ActionsDemoAction : Action {

    data class EmitMessage(val message: String, val delaySec: Int = 0) : ActionsDemoAction()
}

sealed class ActionsDemoEffect : Effect {

    data class AddMessage(val message: String) : ActionsDemoEffect()
}