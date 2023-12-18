package com.example.reduxpoc.screens.home.store

import com.example.reduxpoc.arch.Action
import com.example.reduxpoc.arch.Actor
import com.example.reduxpoc.arch.Effect
import com.example.reduxpoc.arch.Store
import com.example.reduxpoc.arch.Reducer
import com.example.reduxpoc.arch.UiState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emptyFlow

class HomeStore(
    coroutineScope: CoroutineScope,
    actor: HomeActor,
    reducer: HomeReducer
) : Store<HomeUiState, HomeAction, HomeEffect>(coroutineScope, actor, reducer) {
    override val stateFlowInternal = MutableStateFlow(HomeUiState())
}

class HomeUiState : UiState

class HomeActor : Actor<HomeAction, HomeEffect> {

    override fun handle(action: HomeAction): Flow<HomeEffect> {
        when (action) {
            is HomeAction.NavigateStrLen -> action.lambda.invoke()
        }
        return emptyFlow()
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