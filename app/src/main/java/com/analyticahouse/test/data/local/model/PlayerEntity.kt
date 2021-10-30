package com.analyticahouse.test.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.analyticahouse.test.common.Constants.PLAYER_TABLE
import com.google.gson.annotations.SerializedName

@Entity(tableName = PLAYER_TABLE)
data class PlayerEntity(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("height_feet")
    val heightFeet: Any?,
    @SerializedName("height_inches")
    val heightInches: Any?,
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("abbreviation")
    val abbreviation: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("conference")
    val conference: String,
    @SerializedName("division")
    val division: String,
    @SerializedName("full_name")
    val fullName: String
)