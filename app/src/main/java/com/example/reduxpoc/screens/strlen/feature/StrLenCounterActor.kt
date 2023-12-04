package com.example.reduxpoc.screens.strlen.feature

import com.example.reduxpoc.arch.Actor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class StrLenCounterActor : Actor<StrLenCounterAction, StrLenCounterEffect> {
    override fun handle(action: StrLenCounterAction): Flow<StrLenCounterEffect> {
        return when (action) {
            is StrLenCounterAction.UpdateInput -> flowOf(
                StrLenCounterEffect.ValueUpdated(
                    updatedValue = action.strFieldValue,
                    length = action.strFieldValue.length
                )
            )

            is StrLenCounterAction.ClearInput -> flowOf(
                StrLenCounterEffect.ValueUpdated(
                    updatedValue = "",
                    length = 0
                )
            )
        }
    }
}