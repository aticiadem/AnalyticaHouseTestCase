package com.analyticahouse.test.data.local.repository

import com.analyticahouse.test.data.local.TeamDao
import com.analyticahouse.test.domain.model.team.Team
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TeamRepository @Inject constructor(
    private val teamDao: TeamDao
) {

    val getAllFavoriteTeams: Flow<List<Team>> = teamDao.getAllFavoriteTeams()

    fun getSelectedFavoriteTeam(teamId: Int): Flow<Team> {
        return teamDao.getSelectedTeam(teamId = teamId)
    }

    suspend fun addTeam(team: Team) {
        teamDao.addTeam(team = team)
    }

    suspend fun updateTeam(team: Team) {
        teamDao.updateTeam(team = team)
    }

    suspend fun deleteTeam(team: Team) {
        teamDao.deleteTeam(team = team)
    }

    suspend fun deleteAllFavoriteTeam() {
        teamDao.deleteAllFavoriteTeam()
    }

}