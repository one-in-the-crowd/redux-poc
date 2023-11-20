package com.example.reduxpoc.screens.strlen.feature

import com.example.reduxpoc.arch.Effect
import com.example.reduxpoc.arch.Reducer

class StrLenCounterReducer : Reducer<StrLenCounterUiState, StrLenCounterEffect> {
    override fun reduce(state: StrLenCounterUiState, effect: Effect): StrLenCounterUiState {
        return when (effect) {
            is StrLenCounterEffect.ValueUpdated -> state.withEffect(effect)
            else -> state
        }
    }

    private fun StrLenCounterUiState.withEffect(effect: StrLenCounterEffect.ValueUpdated) = copy(
        strFieldValue = effect.updatedValue,
        valueLength = effect.length
    )
}