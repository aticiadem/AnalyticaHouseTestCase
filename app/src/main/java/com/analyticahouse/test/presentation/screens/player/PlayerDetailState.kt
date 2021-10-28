package com.analyticahouse.test.presentation.screens.player

import com.analyticahouse.test.domain.model.player.Player

data class PlayerDetailState(
    val isLoading: Boolean = false,
    val player: Player? = null,
    val error: String = ""
)
