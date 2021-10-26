package com.analyticahouse.test.repository

import com.analyticahouse.test.model.player.Player
import com.analyticahouse.test.model.player.PlayerModel
import com.analyticahouse.test.model.team.Team
import com.analyticahouse.test.model.team.TeamModel
import com.analyticahouse.test.network.BalldontlieAPI
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class BalldontlieRepository @Inject constructor(private val api: BalldontlieAPI) {

    suspend fun getAllTeams(): TeamModel {
        return api.getAllTeams()
    }

    suspend fun getSelectedTeam(teamId: String): Team {
        return api.getSelectedTeam(teamId)
    }

    suspend fun getAllPlayers(): PlayerModel {
        return api.getAllPlayers()
    }

    suspend fun getSelectedPlayer(playerId: String): Player {
        return api.getSelectedPlayer(playerId)
    }

}