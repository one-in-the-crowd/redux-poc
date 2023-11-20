package com.example.reduxpoc.screens.home.feature

import com.example.reduxpoc.arch.Action
import com.example.reduxpoc.arch.Actor
import com.example.reduxpoc.arch.Effect
import com.example.reduxpoc.arch.Feature
import com.example.reduxpoc.arch.Reducer
import com.example.reduxpoc.arch.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.getAndUpdate
import kotlinx.coroutines.launch

class HomeFeature(
    private val coroutineScope: CoroutineScope,
    private val actor: HomeActor,
    private val reducer: HomeReducer
) : Feature<HomeUiState, HomeAction>() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    override val uiState: Flow<HomeUiState> = _uiState
    override fun dispatch(action: HomeAction) {
        // TODO this should be a flow
        coroutineScope.launch {
            val effect = actor.handle(action)
            if (effect != null) {
                _uiState.getAndUpdate { currentState ->
                    reducer.reduce(currentState, effect)
                }
            }
        }
    }
}

class HomeUiState : UiState

class HomeActor : Actor<HomeAction, HomeEffect> {
    override fun handle(action: HomeAction): HomeEffect? {
        when (action) {
            is HomeAction.NavigateStrLen -> action.lambda.invoke()
        }
        return null
    }
}

class HomeReducer : Reducer<HomeUiState, HomeEffect> {
    override fun reduce(state: HomeUiState, effect: Effect): HomeUiState {
        return state
    }
}

sealed class HomeEffect : Effect

sealed class HomeAction : Action {
    class NavigateStrLen(val lambda: () -> Unit) : HomeAction()
}