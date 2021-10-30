package com.analyticahouse.test.domain.model.team

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.analyticahouse.test.common.Constants.TEAM_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = TEAM_TABLE)
data class Team(
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("conference")
    val conference: String,
    @SerializedName("division")
    val division: String,
    @SerializedName("full_name")
    val fullName: String,
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String
)