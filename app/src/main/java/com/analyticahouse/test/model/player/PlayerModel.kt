package com.analyticahouse.test.model.player

import com.google.gson.annotations.SerializedName

data class PlayerModel(
    @SerializedName("data")
    val players: List<Player>
)