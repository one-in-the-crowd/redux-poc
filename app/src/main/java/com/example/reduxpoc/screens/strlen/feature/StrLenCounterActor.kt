package com.example.reduxpoc.screens.strlen.feature

import com.example.reduxpoc.arch.Actor

class StrLenCounterActor : Actor<StrLenCounterAction, StrLenCounterEffect> {
    override suspend fun handle(action: StrLenCounterAction): StrLenCounterEffect? {
        return when (action) {
            is StrLenCounterAction.UpdateInput -> StrLenCounterEffect.ValueUpdated(
                updatedValue = action.strFieldValue, length = action.strFieldValue.length
            )
        }
    }
}