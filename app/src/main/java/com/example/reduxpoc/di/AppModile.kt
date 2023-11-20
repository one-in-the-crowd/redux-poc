package com.example.reduxpoc.di

import com.example.reduxpoc.screens.home.HomeActor
import com.example.reduxpoc.screens.home.HomeReducer
import com.example.reduxpoc.screens.home.HomeScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    viewModelOf(::HomeScreenViewModel)
    factory {
        HomeReducer()
    }
    factory {
        HomeActor()
    }
}