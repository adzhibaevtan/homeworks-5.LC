package com.love.homeworks.ui.viewModel

import androidx.lifecycle.ViewModel
import com.love.homeworks.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val repository: Repository) :

    ViewModel() {
    fun hasUserSeenOnBoarding() {
        repository.onBoardingShow()
    }
}