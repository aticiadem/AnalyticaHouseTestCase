package com.analyticahouse.test.network

import com.analyticahouse.test.model.Data
import com.analyticahouse.test.model.TeamModel
import retrofit2.http.GET
import retrofit2.http.Path

interface TeamsAPI {

    @GET("teams")
    suspend fun getAllTeams(): TeamModel

    @GET("teams/{<ID>}")
    suspend fun getSelectedTeam(@Path("<ID>") teamId: String): Data

}