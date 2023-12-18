package com.example.reduxpoc.di

import com.example.reduxpoc.screens.actionsdemo.store.ActionsDemoActor
import com.example.reduxpoc.screens.actionsdemo.store.ActionsDemoReducer
import com.example.reduxpoc.screens.actionsdemo.ActionsDemoViewModel
import com.example.reduxpoc.screens.home.HomeScreenViewModel
import com.example.reduxpoc.screens.home.store.HomeActor
import com.example.reduxpoc.screens.home.store.HomeReducer
import com.example.reduxpoc.screens.strlen.StrLenCounterViewModel
import com.example.reduxpoc.screens.strlen.store.StrLenCounterActor
import com.example.reduxpoc.screens.strlen.store.StrLenCounterReducer
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

    viewModelOf(::ActionsDemoViewModel)
    factory {
        ActionsDemoActor()
    }
    factory {
        ActionsDemoReducer()
    }
}