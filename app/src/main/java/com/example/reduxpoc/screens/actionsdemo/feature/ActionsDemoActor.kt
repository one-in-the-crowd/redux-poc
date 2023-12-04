package com.example.reduxpoc.screens.actionsdemo.feature

import com.example.reduxpoc.arch.Actor
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import java.util.concurrent.TimeUnit

class ActionsDemoActor : Actor<ActionsDemoAction, ActionsDemoEffect> {

    override suspend fun handle(action: ActionsDemoAction): ActionsDemoEffect? {
        // TODO: use handleF
        return null
//        return when (action) {
//            is ActionsDemoAction.EmitMessage -> action.handle()
//            else -> null
//        }
    }

    fun handleF(action: ActionsDemoAction): Flow<ActionsDemoEffect> {
        return when (action) {
            is ActionsDemoAction.EmitMessage -> action.handle()
            else -> emptyFlow()
        }
    }

    private fun ActionsDemoAction.EmitMessage.handle(): Flow<ActionsDemoEffect> {
        return flow {
            emit(ActionsDemoEffect.AddMessage(">>> start $message"))
            delay(TimeUnit.SECONDS.toMillis(delaySec.toLong()))
            emit(ActionsDemoEffect.AddMessage(message))
        }
    }
}