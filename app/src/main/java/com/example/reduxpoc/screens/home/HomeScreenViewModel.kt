package com.example.reduxpoc.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reduxpoc.screens.home.store.HomeAction
import com.example.reduxpoc.screens.home.store.HomeActor
import com.example.reduxpoc.screens.home.store.HomeStore
import com.example.reduxpoc.screens.home.store.HomeReducer
import com.example.reduxpoc.screens.home.store.HomeUiState
import kotlinx.coroutines.flow.Flow

class HomeScreenViewModel(
    actor: HomeActor,
    reducer: HomeReducer
) : ViewModel() {

    private val store: HomeStore = HomeStore(viewModelScope, actor, reducer)

    val uiState: Flow<HomeUiState> = store.uiState
    fun dispatch(action: HomeAction) = store.dispatch(action)
}