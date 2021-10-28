package com.analyticahouse.test.presentation.screens.team

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.analyticahouse.test.common.Resource
import com.analyticahouse.test.domain.use_case.get_team.GetTeamsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TeamsViewModel @Inject constructor(
    private val getTeamsUseCase: GetTeamsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(TeamsListState())
    val state: State<TeamsListState> = _state

    init {
        getTeams()
    }

    private fun getTeams() {
        getTeamsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = TeamsListState(teams = result.data?.teams ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = TeamsListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = TeamsListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}