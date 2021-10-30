package com.analyticahouse.test.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.analyticahouse.test.data.local.model.PlayerEntity

@Dao
interface PlayerDao {
    @Query("SELECT * FROM player_table")
    fun getAllFavoritePlayers(): LiveData<List<PlayerEntity>>

    @Query("SELECT * FROM player_table WHERE id= :playerId")
    fun getSelectedPlayer(playerId: Int): PlayerEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlayer(player: PlayerEntity)

    @Update
    suspend fun updatePlayer(player: PlayerEntity)

    @Delete
    suspend fun deletePlayer(player: PlayerEntity)

    @Query("DELETE FROM player_table")
    suspend fun deleteAllFavoritePlayers()
}