package com.example.reduxpoc

sealed class Destination(val route: String) {
    object Home: Destination("home")
    object StrLenCounter: Destination("str-len-counter")
}