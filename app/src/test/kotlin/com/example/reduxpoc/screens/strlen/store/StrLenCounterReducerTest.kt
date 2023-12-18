package com.example.reduxpoc.screens.strlen.store

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrLenCounterReducerTest {

    private val sut = StrLenCounterReducer()

    @Test
    fun `GIVEN effect ValueUpdated WHEN reduce THEN has updated state`() {
        val state = StrLenCounterUiState.INITIAL
        val effect = StrLenCounterEffect.ValueUpdated(updatedValue = "input", length = 5)

        val updatedState = sut.reduce(state, effect)

        assertEquals(
            StrLenCounterUiState(
                strFieldValue = "input",
                valueLength = 5
            ),
            updatedState
        )
    }
}