package com.analyticahouse.test.domain.model.player

import com.google.gson.annotations.SerializedName

data class PlayerModel(
    @SerializedName("data")
    val players: List<Player>
)