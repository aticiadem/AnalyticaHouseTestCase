package com.analyticahouse.test.presentation.screens.favorite

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.analyticahouse.test.data.local.model.PlayerEntity
import com.analyticahouse.test.data.local.repository.PlayerRepository
import com.analyticahouse.test.domain.model.team.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class FavoritePlayersViewModel @Inject constructor(
    private val playerRepository: PlayerRepository
) : ViewModel() {

    private val _favoritePlayerList: MutableState<List<PlayerEntity>> = mutableStateOf(emptyList())

    val favoritePlayerList: State<List<PlayerEntity>>
        get() = _favoritePlayerList

    init {
        viewModelScope.launch {
            try {
                _favoritePlayerList.value = getAllFavoritePlayers()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private suspend fun getAllFavoritePlayers(): List<PlayerEntity> {
        return playerRepository.getAllFavoritePlayers()
    }

    fun getSelectedPlayer(playerId: Int): PlayerEntity {
        return playerRepository.getSelectedFavoritePlayer(playerId = playerId)
    }

    fun addFavoritePlayer(player: PlayerEntity) {
        viewModelScope.launch(Dispatchers.IO) {
            playerRepository.addPlayer(player = player)
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