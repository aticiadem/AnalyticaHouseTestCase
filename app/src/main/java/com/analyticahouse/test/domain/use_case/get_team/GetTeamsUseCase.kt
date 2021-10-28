package com.analyticahouse.test.domain.use_case.get_team

import com.analyticahouse.test.common.Resource
import com.analyticahouse.test.data.repository.BalldontlieRepository
import com.analyticahouse.test.domain.model.team.TeamModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeamsUseCase @Inject constructor(
    private val repository: BalldontlieRepository
) {
    operator fun invoke(): Flow<Resource<TeamModel>> = flow {
        try {
            emit(Resource.Loading())
            val teams = repository.getAllTeams()
            emit(Resource.Success(teams))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}