package com.example.reduxpoc.arch

import kotlinx.coroutines.flow.Flow

abstract class Feature<S : UiState, A : Action> {

    abstract val uiState: Flow<UiState>
    abstract fun dispatch(action: A)
}