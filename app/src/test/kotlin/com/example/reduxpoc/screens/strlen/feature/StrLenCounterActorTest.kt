package com.example.reduxpoc.screens.strlen.feature

import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StrLenCounterActorTest {

    private val sut = StrLenCounterActor()

    @Test
    fun `GIVEN action UpdateInput WHEN handle THEN return ValueUpdated effect`() = runTest {
        val action = StrLenCounterAction.UpdateInput("input")

        val effects = sut.handle(action).toList()

        assertEquals(
            listOf(
                StrLenCounterEffect.ValueUpdated(
                    updatedValue = "input",
                    length = 5
                )
            ),
            effects
        )
    }

    @Test
    fun `GIVEN action ClearInput WHEN handle THEN return ValueUpdated effect`() = runTest {
        val action = StrLenCounterAction.ClearInput

        val effects = sut.handle(action).toList()

        assertEquals(
            listOf(
                StrLenCounterEffect.ValueUpdated(
                    updatedValue = "",
                    length = 0
                )
            ),
            effects
        )
    }
}