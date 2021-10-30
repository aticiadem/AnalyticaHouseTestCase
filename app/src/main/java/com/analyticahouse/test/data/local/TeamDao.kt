package com.analyticahouse.test.data.local

import androidx.room.*
import com.analyticahouse.test.domain.model.team.Team
import kotlinx.coroutines.flow.Flow

@Dao
interface TeamDao {
    @Query("SELECT * FROM team_table")
    fun getAllFavoriteTeams(): Flow<List<Team>>

    @Query("SELECT * FROM team_table WHERE id= :teamId")
    fun getSelectedTeam(teamId: Int): Flow<Team>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTeam(team: Team)

    @Update
    suspend fun updateTeam(team: Team)

    @Delete
    suspend fun deleteTeam(team: Team)

    @Query("DELETE FROM team_table")
    suspend fun deleteAllFavoriteTeam()
}