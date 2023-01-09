package com.love.homeworks.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.love.homeworks.model.LoveModel
import com.love.homeworks.repository.Repository
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(private val repository: Repository): ViewModel() {
    lateinit var liveLoveData : LiveData<List<LoveModel>>

    fun getAlLiveLove() {
        liveLoveData = repository.getAlLove()
    }
}