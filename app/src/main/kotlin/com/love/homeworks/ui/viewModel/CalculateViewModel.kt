package com.love.homeworks.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.love.homeworks.model.LoveModel
import com.love.homeworks.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CalculateViewModel @Inject constructor(
    private val repository: Repository
): ViewModel(){

    fun getLiveLoveModel(firstName:String,secondName: String): LiveData<LoveModel> {
        return repository.getLiveLove(firstName,secondName)
    }

    fun insertLove(item: LoveModel) {
        repository.insertLove(item)
    }

}