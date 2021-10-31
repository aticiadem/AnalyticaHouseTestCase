package com.analyticahouse.test.data.local.repository

import com.analyticahouse.test.data.local.PlayerDao
import com.analyticahouse.test.data.local.model.PlayerEntity
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class PlayerRepository @Inject constructor(
    private val playerDao: PlayerDao
) {

    suspend fun getAllFavoritePlayers(): List<PlayerEntity> {
        return playerDao.getAllFavoritePlayers()
    }

    fun getSelectedFavoritePlayer(playerId: Int): PlayerEntity {
        return playerDao.getSelectedPlayer(playerId = playerId)
    }

    suspend fun addPlayer(player: PlayerEntity) {
        playerDao.addPlayer(player = player)
    }

    suspend fun deletePlayer(player: PlayerEntity) {
        playerDao.deletePlayer(player = player)
    }

    suspend fun deleteAllFavoritePlayer() {
        playerDao.deleteAllFavoritePlayers()
    }

}