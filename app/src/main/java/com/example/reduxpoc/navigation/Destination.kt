package com.example.reduxpoc.navigation

sealed class Destination(val route: String) {
    object Home: Destination("home")
    object StrLenCounter: Destination("str-len-counter")
    object ActionsDemo: Destination("actions-demo")
}