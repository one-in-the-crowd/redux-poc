package com.example.reduxpoc.screens.actionsdemo.feature

import com.example.reduxpoc.arch.Action
import com.example.reduxpoc.arch.Effect
import com.example.reduxpoc.arch.Feature
import com.example.reduxpoc.arch.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flatMapMerge
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.launch

class ActionsDemoFeature(
    private val coroutineScope: CoroutineScope,
    private val actor: ActionsDemoActor,
    private val reducer: ActionsDemoReducer
) : Feature<ActionsDemoUiState, ActionsDemoAction>() {

    private companion object {
        val INITIAL_STATE = ActionsDemoUiState()
    }

    private val actionsFlow = MutableSharedFlow<ActionsDemoAction>()
    private val reducedStateFlow: Flow<ActionsDemoUiState> = actionsFlow
        .distinctUntilChanged()
        .flatMapMerge {
            actor.handleF(it)
        }
        .map { effect ->
            stateFlowInternal.getAndUpdate { state ->
                reducer.reduce(state, effect)
            }
        }

    private val stateFlowInternal = MutableStateFlow(INITIAL_STATE)

    override val uiState: Flow<ActionsDemoUiState> = merge(
        reducedStateFlow,
        stateFlowInternal
    ).distinctUntilChanged()

    override fun dispatch(action: ActionsDemoAction) {
        coroutineScope.launch {
            actionsFlow.emit(action)
        }
    }
}

data class ActionsDemoUiState(
    val messages: List<String> = emptyList()
) : UiState

sealed class ActionsDemoAction : Action {

    data class EmitMessage(val message: String, val delaySec: Int = 0) : ActionsDemoAction()
}

sealed class ActionsDemoEffect : Effect {

    data class AddMessage(val message: String) : ActionsDemoEffect()
}