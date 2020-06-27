package com.example.covid.cure.ui.splash

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.covid.cure.R
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class SplashActivity : ComponentActivity() {

    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupViewModel()
        observeViewModel()
    }

    private fun setupViewModel() {
        splashViewModel = ViewModelProvider(this)[SplashViewModel::class.java]
    }

    private fun observeViewModel() {
        lifecycleScope.launch {
            splashViewModel.state.collect {
                when(it){
                    SplashState.LoadHomeScreen -> {

                    }
                }
            }
        }
    }
}