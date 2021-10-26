package com.analyticahouse.test.network

import com.analyticahouse.test.model.player.Player
import com.analyticahouse.test.model.player.PlayerModel
import com.analyticahouse.test.model.team.Team
import com.analyticahouse.test.model.team.TeamModel
import retrofit2.http.GET
import retrofit2.http.Path

interface BalldontlieAPI {

    @GET("teams")
    suspend fun getAllTeams(): TeamModel

    @GET("teams/{<ID>}")
    suspend fun getSelectedTeam(@Path("<ID>") teamId: String): Team

    @GET("players")
    suspend fun getAllPlayers(): PlayerModel

    @GET("players/{<ID>}")
    suspend fun getSelectedPlayer(@Path("<ID>") playerId: String): Player

}