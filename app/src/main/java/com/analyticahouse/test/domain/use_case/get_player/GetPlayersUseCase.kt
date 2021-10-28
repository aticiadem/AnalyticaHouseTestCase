package com.analyticahouse.test.domain.use_case.get_player

import com.analyticahouse.test.common.Resource
import com.analyticahouse.test.data.repository.BalldontlieRepository
import com.analyticahouse.test.domain.model.player.PlayerModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPlayersUseCase @Inject constructor(
    private val repository: BalldontlieRepository
) {
    operator fun invoke(): Flow<Resource<PlayerModel>> = flow {
        try {
            emit(Resource.Loading())
            val players = repository.getAllPlayers()
            emit(Resource.Success(players))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}