package com.analyticahouse.test.presentation.screens.team

import com.analyticahouse.test.domain.model.team.Team

data class TeamDetailState(
    val isLoading: Boolean = false,
    val team: Team? = null,
    val error: String = ""
)