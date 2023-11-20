package com.example.reduxpoc

sealed class Destination(val route: String) {
    object Home: Destination("home")
    object StringLengthCounter: Destination("str-len-counter")
}