package com.example.reduxpoc.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reduxpoc.screens.home.feature.HomeAction
import com.example.reduxpoc.screens.home.feature.HomeActor
import com.example.reduxpoc.screens.home.feature.HomeFeature
import com.example.reduxpoc.screens.home.feature.HomeReducer
import com.example.reduxpoc.screens.home.feature.HomeUiState
import kotlinx.coroutines.flow.Flow

class HomeScreenViewModel(
    actor: HomeActor,
    reducer: HomeReducer
) : ViewModel() {

    private val feature: HomeFeature = HomeFeature(viewModelScope, actor, reducer)

    val uiState: Flow<HomeUiState> = feature.uiState
    fun dispatch(action: HomeAction) = feature.dispatch(action)
}