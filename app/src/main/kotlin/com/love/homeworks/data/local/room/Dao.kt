package com.love.homeworks.data.local.room

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.love.homeworks.model.LoveModel

@androidx.room.Dao


interface Dao {
@Insert
 fun insertLove(model:LoveModel)
 @Query("SELECT * FROM lovemodel ORDER BY firstName ASC")
 fun getAlLove() : LiveData<List<LoveModel>>
}