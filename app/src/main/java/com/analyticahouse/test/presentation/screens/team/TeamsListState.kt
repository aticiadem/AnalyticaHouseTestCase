package com.analyticahouse.test.presentation.screens.team

import com.analyticahouse.test.domain.model.team.Team

data class TeamsListState(
    val isLoading: Boolean = false,
    val teams: List<Team> = emptyList(),
    val error: String = ""
)