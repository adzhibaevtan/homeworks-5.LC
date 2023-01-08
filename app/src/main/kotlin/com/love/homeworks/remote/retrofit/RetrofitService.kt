package com.love.homeworks.remote.retrofit

import com.love.homeworks.remote.api.LoveApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {
   private val retrofit = Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getLoveApi(): LoveApi = retrofit.create(LoveApi::class.java)
}