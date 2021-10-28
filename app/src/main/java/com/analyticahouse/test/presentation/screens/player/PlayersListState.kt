package com.analyticahouse.test.presentation.screens.player

import com.analyticahouse.test.domain.model.player.Player

data class PlayersListState(
    val isLoading: Boolean = false,
    val players: List<Player> = emptyList(),
    val error: String = ""
)