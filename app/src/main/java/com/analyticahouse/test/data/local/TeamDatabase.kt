package com.analyticahouse.test.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.analyticahouse.test.domain.model.team.Team

@Database(entities = [Team::class], version = 1, exportSchema = false)
abstract class TeamDatabase : RoomDatabase() {
    abstract fun teamDao(): TeamDao
}