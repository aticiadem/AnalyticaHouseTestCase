package com.analyticahouse.test.model.player

import com.analyticahouse.test.model.team.Team
import com.google.gson.annotations.SerializedName

data class Player(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("height_feet")
    val heightFeet: Any?,
    @SerializedName("height_inches")
    val heightInches: Any?,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String,
    @SerializedName("position")
    val position: String,
    @SerializedName("team")
    val team: Team,
    @SerializedName("weight_pounds")
    val weightPounds: Any?
)