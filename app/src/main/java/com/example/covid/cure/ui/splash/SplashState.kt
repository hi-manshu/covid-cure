package com.example.covid.cure.ui.splash

sealed class SplashState {

    object LoadHomeScreen : SplashState()
    object Idle : SplashState()

}