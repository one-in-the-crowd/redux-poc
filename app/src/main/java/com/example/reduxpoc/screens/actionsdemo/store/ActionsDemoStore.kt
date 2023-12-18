package com.example.reduxpoc.screens.actionsdemo.store

import com.example.reduxpoc.arch.Action
import com.example.reduxpoc.arch.Effect
import com.example.reduxpoc.arch.Store
import com.example.reduxpoc.arch.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow

class ActionsDemoStore(
    coroutineScope: CoroutineScope, actor: ActionsDemoActor, reducer: ActionsDemoReducer
) : Store<ActionsDemoUiState, ActionsDemoAction, ActionsDemoEffect>(
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