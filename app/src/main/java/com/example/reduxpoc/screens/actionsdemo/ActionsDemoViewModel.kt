package com.example.reduxpoc.screens.actionsdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reduxpoc.screens.actionsdemo.feature.ActionsDemoAction
import com.example.reduxpoc.screens.actionsdemo.feature.ActionsDemoActor
import com.example.reduxpoc.screens.actionsdemo.feature.ActionsDemoFeature
import com.example.reduxpoc.screens.actionsdemo.feature.ActionsDemoReducer
import com.example.reduxpoc.screens.actionsdemo.feature.ActionsDemoUiState
import kotlinx.coroutines.flow.Flow

class ActionsDemoViewModel(
    actor: ActionsDemoActor,
    reducer: ActionsDemoReducer
) : ViewModel() {

    private val feature: ActionsDemoFeature = ActionsDemoFeature(viewModelScope, actor, reducer)

    val uiState: Flow<ActionsDemoUiState> = feature.uiState
    fun dispatch(action: ActionsDemoAction) = feature.dispatch(action)
}