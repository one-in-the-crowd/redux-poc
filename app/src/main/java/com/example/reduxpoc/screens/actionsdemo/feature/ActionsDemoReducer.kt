package com.example.reduxpoc.screens.actionsdemo.feature

import com.example.reduxpoc.arch.Effect
import com.example.reduxpoc.arch.Reducer

class ActionsDemoReducer : Reducer<ActionsDemoUiState, ActionsDemoEffect> {

    override fun reduce(state: ActionsDemoUiState, effect: Effect): ActionsDemoUiState {
        return when (effect) {
            is ActionsDemoEffect.AddMessage -> state.withEffect(effect)
            else -> state
        }
    }

    private fun ActionsDemoUiState.withEffect(effect: ActionsDemoEffect.AddMessage): ActionsDemoUiState {
        return copy(messages = messages + effect.message)
    }
}