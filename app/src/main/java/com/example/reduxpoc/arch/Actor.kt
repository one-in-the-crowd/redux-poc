package com.example.reduxpoc.arch

interface Actor<A : Action, E : Effect> {
    suspend fun handle(action: A): E?
}