package com.analyticahouse.test.presentation.screens.favorite

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.analyticahouse.test.data.local.repository.TeamRepository
import com.analyticahouse.test.domain.model.team.Team
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class FavoriteTeamsViewModel @Inject constructor(
    private val teamRepository: TeamRepository
) : ViewModel() {

    private val _favoriteTeamList: MutableState<List<Team>> = mutableStateOf(emptyList())

    val favoriteTeamList: State<List<Team>>
        get() = _favoriteTeamList

    init {
        viewModelScope.launch {
            try {
                _favoriteTeamList.value = getAllFavoriteTeams()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private suspend fun getAllFavoriteTeams(): List<Team> {
        return teamRepository.getAllFavoriteTeams()
    }

    fun getSelectedTeam(teamId: Int): Team {
        return teamRepository.getSelectedFavoriteTeam(teamId = teamId)
    }

    fun addFavoriteTeam(team: Team) {
        viewModelScope.launch(Dispatchers.IO) {
            teamRepository.addTeam(team = team)
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