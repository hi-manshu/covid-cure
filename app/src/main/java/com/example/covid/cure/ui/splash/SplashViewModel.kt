package com.example.covid.cure.ui.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.covid.cure.util.Event
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class SplashViewModel : ViewModel() {

    private val splashEvent = Channel<SplashEvents>(Channel.UNLIMITED)
    private val _state = MutableStateFlow<SplashState>(SplashState.Idle)
    val state: StateFlow<SplashState>
        get() = _state

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            splashEvent.consumeAsFlow().collect {
                when (it) {
                    is SplashEvents.LoadHomeScreen -> launchMainView()
                }
            }
        }
    }

    private fun launchMainView() {
        viewModelScope.launch {
            _state.value = SplashState.LoadHomeScreen
        }
    }
}