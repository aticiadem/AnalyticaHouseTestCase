package com.analyticahouse.test.domain.use_case.get_team

import com.analyticahouse.test.common.Resource
import com.analyticahouse.test.data.repository.BalldontlieRepository
import com.analyticahouse.test.domain.model.team.Team
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetTeamByIdUseCase @Inject constructor(
    private val repository: BalldontlieRepository
) {
    operator fun invoke(teamId: String): Flow<Resource<Team>> = flow {
        try {
            emit(Resource.Loading())
            val team = repository.getSelectedTeam(teamId = teamId)
            emit(Resource.Success(team))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}