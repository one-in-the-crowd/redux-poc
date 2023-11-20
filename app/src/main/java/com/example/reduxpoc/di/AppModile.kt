package com.example.reduxpoc.di

import com.example.reduxpoc.screens.home.HomeScreenViewModel
import com.example.reduxpoc.screens.home.feature.HomeActor
import com.example.reduxpoc.screens.home.feature.HomeReducer
import com.example.reduxpoc.screens.strlen.StrLenCounterViewModel
import com.example.reduxpoc.screens.strlen.feature.StrLenCounterActor
import com.example.reduxpoc.screens.strlen.feature.StrLenCounterReducer
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

    viewModelOf(::StrLenCounterViewModel)
    factory {
        StrLenCounterActor()
    }
    factory {
        StrLenCounterReducer()
    }
}