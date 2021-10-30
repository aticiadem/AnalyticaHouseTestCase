package com.analyticahouse.test.presentation.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.analyticahouse.test.data.local.model.PlayerEntity
import com.analyticahouse.test.data.local.repository.PlayerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoritePlayersViewModel @Inject constructor(
    private val playerRepository: PlayerRepository
) : ViewModel() {

    val getAllFavoritePlayers: LiveData<List<PlayerEntity>> =
        playerRepository.getAllFavoritePlayers

    fun getSelectedPlayer(playerId: Int): PlayerEntity {
        return playerRepository.getSelectedFavoritePlayer(playerId = playerId)
    }

    fun addFavoritePlayer(player: PlayerEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            playerRepository.addPlayer(player = player)
        }
    }

    fun updateFavoritePlayer(player: PlayerEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            playerRepository.updatePlayer(player = player)
        }
    }

    fun deleteFavoritePlayer(player: PlayerEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            playerRepository.deletePlayer(player = player)
        }
    }

    fun deleteAllFavoritePlayer() {
        viewModelScope.launch(Dispatchers.IO) {
            playerRepository.deleteAllFavoritePlayer()
        }
    }

}