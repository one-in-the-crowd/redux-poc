package com.example.reduxpoc.arch

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

abstract class Store<S : UiState, A : Action, E : Effect>(
    private val coroutineScope: CoroutineScope,
    actor: Actor<A, E>,
    reducer: Reducer<S, E>
) {
    protected abstract val stateFlowInternal: MutableStateFlow<S>

    private val actionsFlow = MutableSharedFlow<A>()

    private val reducedStateFlow: Flow<S> = actionsFlow
        .distinctUntilChanged()
        .flatMapMerge {
            actor.handle(it)
        }.map { effect ->
            stateFlowInternal.getAndUpdate { state ->
                reducer.reduce(state, effect)
            }
        }

    val uiState: Flow<S>
        get() = merge(reducedStateFlow, stateFlowInternal).distinctUntilChanged()

    fun dispatch(action: A) {
        coroutineScope.launch {
            actionsFlow.emit(action)
        }
    }
}