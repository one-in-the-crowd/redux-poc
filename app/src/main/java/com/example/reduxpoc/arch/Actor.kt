package com.example.reduxpoc.arch

interface Actor<A : Action, E : Effect> {
    fun handle(action: A): E?
}