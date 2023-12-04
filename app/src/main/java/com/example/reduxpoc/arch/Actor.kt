package com.example.reduxpoc.arch

import kotlinx.coroutines.flow.Flow

interface Actor<A : Action, E : Effect> {
    fun handle(action: A): Flow<E>
}