package com.analyticahouse.test.presentation.screens.player

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.analyticahouse.test.common.Resource
import com.analyticahouse.test.domain.use_case.get_player.GetPlayersUseCase
import com.analyticahouse.test.presentation.screens.team.TeamsListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlayersViewModel @Inject constructor(
    private val getPlayersUseCase: GetPlayersUseCase
) : ViewModel() {

    private val _state = mutableStateOf(PlayersListState())
    val state: State<PlayersListState> = _state

    init {
        getPlayers()
    }

    private fun getPlayers() {
        getPlayersUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PlayersListState(players = result.data?.players ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = PlayersListState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PlayersListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}