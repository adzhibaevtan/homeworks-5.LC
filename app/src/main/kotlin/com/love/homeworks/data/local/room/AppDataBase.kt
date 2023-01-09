package com.love.homeworks.data.local.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.love.homeworks.model.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun getDao() : Dao

}