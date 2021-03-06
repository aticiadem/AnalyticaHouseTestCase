package com.analyticahouse.test.data.local

import androidx.room.*
import com.analyticahouse.test.domain.model.team.Team

@Dao
interface TeamDao {
    @Query("SELECT * FROM team_table")
    suspend fun getAllFavoriteTeams(): List<Team>

    @Query("SELECT * FROM team_table WHERE id= :teamId")
    fun getSelectedTeam(teamId: Int): Team

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTeam(team: Team)

    @Delete
    suspend fun deleteTeam(team: Team)

    @Query("DELETE FROM team_table")
    suspend fun deleteAllFavoriteTeam()
}