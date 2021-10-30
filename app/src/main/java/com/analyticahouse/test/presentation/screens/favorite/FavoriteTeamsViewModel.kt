package com.analyticahouse.test.presentation.screens.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.analyticahouse.test.data.local.repository.TeamRepository
import com.analyticahouse.test.domain.model.team.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavoriteTeamsViewModel @Inject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {

    val getAllFavoriteTeams: LiveData<List<Team>> =
        teamRepository.getAllFavoriteTeams

    fun getSelectedTeam(teamId: Int): Team {
        return teamRepository.getSelectedFavoriteTeam(teamId = teamId)
    }

    fun addFavoriteTeam(team: Team) {
        viewModelScope.launch(Dispatchers.IO) {
            teamRepository.addTeam(team = team)
        }
    }

    fun updateFavoriteTeam(team: Team) {
        viewModelScope.launch(Dispatchers.IO) {
            teamRepository.updateTeam(team = team)
        }
    }

    fun deleteFavoriteTeam(team: Team) {
        viewModelScope.launch(Dispatchers.IO) {
            teamRepository.deleteTeam(team = team)
        }
    }

    fun deleteAllFavoriteTeam() {
        viewModelScope.launch(Dispatchers.IO) {
            teamRepository.deleteAllFavoriteTeam()
        }
    }

}