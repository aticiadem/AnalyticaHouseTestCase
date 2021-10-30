package com.analyticahouse.test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.analyticahouse.test.data.local.model.PlayerEntity

@Database(entities = [PlayerEntity::class], version = 1, exportSchema = false)
abstract class PlayerDatabase : RoomDatabase() {
    abstract fun playerDao() : PlayerDao
}