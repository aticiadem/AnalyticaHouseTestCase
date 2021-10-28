package com.analyticahouse.test.presentation.screens.team

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.analyticahouse.test.common.Constants
import com.analyticahouse.test.common.Resource
import com.analyticahouse.test.domain.use_case.get_team.GetTeamByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamDetailViewModel @Inject constructor(
    private val getTeamByIdUseCase: GetTeamByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _state = mutableStateOf(TeamDetailState())
    val state: State<TeamDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_TEAM_ID)?.let { teamId ->
            getTeamByID(teamId = teamId)
        }
    }

    private fun getTeamByID(teamId: String) {
        getTeamByIdUseCase(teamId = teamId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = TeamDetailState(team = result.data)
                }
                is Resource.Error -> {
                    _state.value = TeamDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = TeamDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}