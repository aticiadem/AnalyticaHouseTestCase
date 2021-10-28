package com.analyticahouse.test.domain.use_case.get_player

import com.analyticahouse.test.common.Resource
import com.analyticahouse.test.data.repository.BalldontlieRepository
import com.analyticahouse.test.domain.model.player.Player
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPlayerByIdUseCase @Inject constructor(
    private val repository: BalldontlieRepository
) {
    operator fun invoke(playerId: String): Flow<Resource<Player>> = flow {
        try {
            emit(Resource.Loading())
            val player = repository.getSelectedPlayer(playerId = playerId)
            emit(Resource.Success(player))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}