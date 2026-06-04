package com.sbz.zennotes.ui.screens.onboarding

import androidx.lifecycle.ViewModel
import com.sbz.zennotes.data.repository.UserPreferencesRepository

class SplashViewModel(
    private val repository: UserPreferencesRepository
) : ViewModel() {

    val isFirstTimeUser = repository.isFirstTimeUser

}