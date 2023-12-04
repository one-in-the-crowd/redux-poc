package com.example.reduxpoc.screens.actionsdemo.feature

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow

class ActionsDemoViewModel(
    actor: ActionsDemoActor,
    reducer: ActionsDemoReducer
) : ViewModel() {

    private val feature: ActionsDemoFeature = ActionsDemoFeature(viewModelScope, actor, reducer)

    val uiState: Flow<ActionsDemoUiState> = feature.uiState
    fun dispatch(action: ActionsDemoAction) = feature.dispatch(action)
}