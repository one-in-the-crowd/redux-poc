package com.example.reduxpoc.arch

interface Reducer<S : UiState, E : Effect> {
    fun reduce(state: S, effect: Effect): S
}