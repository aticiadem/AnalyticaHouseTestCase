package com.analyticahouse.test.domain.model.team

import com.google.gson.annotations.SerializedName

data class TeamModel(
    @SerializedName("data")
    val teams: List<Team>
)