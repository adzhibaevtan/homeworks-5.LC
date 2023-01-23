package com.love.homeworks.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import com.love.homeworks.data.local.room.AppDataBase
import com.love.homeworks.data.local.room.Dao
import com.love.homeworks.remote.api.LoveApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun apiProvide(): LoveApi {
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build().create(LoveApi::class.java)
    }

    @Provides
    fun sharedPreferencesProvide(context: Application): SharedPreferences {
        return context.getSharedPreferences("preferences", Context.MODE_PRIVATE)

    }

    @Provides
    fun loveDaoProvide(appDataBase: AppDataBase): Dao {
        return appDataBase.getDao()
    }

    @Provides
    @Singleton
    fun appDataBaseProvide(@ApplicationContext applicationContext: Context):
            AppDataBase {
        return Room.databaseBuilder(
            applicationContext,AppDataBase::class.java,"love").allowMainThreadQueries().build()
    }
}