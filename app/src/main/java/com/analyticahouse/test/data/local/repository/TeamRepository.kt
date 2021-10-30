package com.analyticahouse.test.data.local.repository

import androidx.lifecycle.LiveData
import com.analyticahouse.test.data.local.TeamDao
import com.analyticahouse.test.domain.model.team.Team
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class TeamRepository @Inject constructor(
    private val teamDao: TeamDao
) {

    val getAllFavoriteTeams: LiveData<List<Team>> = teamDao.getAllFavoriteTeams()

    fun getSelectedFavoriteTeam(teamId: Int): Team {
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