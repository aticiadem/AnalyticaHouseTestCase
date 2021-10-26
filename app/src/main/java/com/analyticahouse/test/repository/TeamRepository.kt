package com.analyticahouse.test.repository

import com.analyticahouse.test.model.Data
import com.analyticahouse.test.model.TeamModel
import com.analyticahouse.test.network.TeamsAPI
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class TeamRepository @Inject constructor(private val api: TeamsAPI) {

    suspend fun getAllTeams(): TeamModel {
        return api.getAllTeams()
    }

    suspend fun getSelectedTeam(teamId: String): Data {
        return api.getSelectedTeam(teamId)
    }

}