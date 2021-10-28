package com.analyticahouse.test.presentation.screens.player

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.analyticahouse.test.common.Constants
import com.analyticahouse.test.common.Resource
import com.analyticahouse.test.domain.use_case.get_player.GetPlayerByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PlayerDetailViewModel @Inject constructor(
    private val getPlayerByIdUseCase: GetPlayerByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(PlayerDetailState())
    val state: State<PlayerDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_PLAYER_ID)?.let { playerId ->
            getPlayerByID(playerId = playerId)
        }
    }

    private fun getPlayerByID(playerId: String) {
        getPlayerByIdUseCase(playerId = playerId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PlayerDetailState(player = result.data)
                }
                is Resource.Error -> {
                    _state.value = PlayerDetailState(
                        error = result.message ?: "An unexpected error occurred"
                    )
                }
                is Resource.Loading -> {
                    _state.value = PlayerDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }

}