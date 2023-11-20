package com.example.reduxpoc.screens.home

sealed class Destination(val route: String) {
    object Home: Destination("home")
}