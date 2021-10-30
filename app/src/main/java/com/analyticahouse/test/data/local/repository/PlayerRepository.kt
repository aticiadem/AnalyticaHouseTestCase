package com.analyticahouse.test.data.local.repository

import com.analyticahouse.test.data.local.PlayerDao
import com.analyticahouse.test.data.local.model.PlayerEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PlayerRepository @Inject constructor(
    private val playerDao: PlayerDao
) {

    val getAllFavoritePlayers: Flow<List<PlayerEntity>> = playerDao.getAllFavoritePlayers()

    fun getSelectedFavoritePlayer(playerId: Int): Flow<PlayerEntity> {
        return playerDao.getSelectedPlayer(playerId = playerId)
    }

    suspend fun addPlayer(player: PlayerEntity) {
        playerDao.addPlayer(player = player)
    }

    suspend fun updatePlayer(player: PlayerEntity) {
        playerDao.updatePlayer(player = player)
    }

    suspend fun deletePlayer(player: PlayerEntity) {
        playerDao.deletePlayer(player = player)
    }

    suspend fun deleteAllFavoritePlayer() {
        playerDao.deleteAllFavoritePlayers()
    }

}