package com.analyticahouse.test.data.local

import androidx.room.*
import com.analyticahouse.test.data.local.model.PlayerEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PlayerDao {
    @Query("SELECT * FROM player_table")
    fun getAllFavoritePlayers(): Flow<List<PlayerEntity>>

    @Query("SELECT * FROM player_table WHERE id= :playerId")
    fun getSelectedPlayer(playerId: Int): Flow<PlayerEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addPlayer(player: PlayerEntity)

    @Update
    suspend fun updatePlayer(player: PlayerEntity)

    @Delete
    suspend fun deletePlayer(player: PlayerEntity)

    @Query("DELETE FROM player_table")
    suspend fun deleteAllFavoritePlayers()
}