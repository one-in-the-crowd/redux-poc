package com.example.reduxpoc.screens.actionsdemo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reduxpoc.screens.actionsdemo.store.ActionsDemoAction
import com.example.reduxpoc.screens.actionsdemo.store.ActionsDemoActor
import com.example.reduxpoc.screens.actionsdemo.store.ActionsDemoStore
import com.example.reduxpoc.screens.actionsdemo.store.ActionsDemoReducer
import com.example.reduxpoc.screens.actionsdemo.store.ActionsDemoUiState
import kotlinx.coroutines.flow.Flow

class ActionsDemoViewModel(
    actor: ActionsDemoActor,
    reducer: ActionsDemoReducer
) : ViewModel() {

    private val store: ActionsDemoStore = ActionsDemoStore(viewModelScope, actor, reducer)

    val uiState: Flow<ActionsDemoUiState> = store.uiState
    fun dispatch(action: ActionsDemoAction) = store.dispatch(action)
}