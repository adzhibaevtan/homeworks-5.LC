package com.love.homeworks.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.love.homeworks.data.local.room.Dao
import com.love.homeworks.model.LoveModel
import com.love.homeworks.remote.api.LoveApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveApi,private val dao: Dao) {

    
    fun getLiveLove(firstName: String, secondName: String): MutableLiveData<LoveModel> {
        val liveData = MutableLiveData<LoveModel> ()
        api.getResultLove(firstName,secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if (response.isSuccessful) {
                    liveData.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("check", "onFailure: "+ t.message )
            }

        })
        return liveData
    }

    fun getAlLove(): LiveData<List<LoveModel>> {
        return dao.getAlLove()
    }

    fun insertLove(item:LoveModel){
        dao.insertLove(item)
    }



}