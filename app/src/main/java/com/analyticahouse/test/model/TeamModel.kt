package com.analyticahouse.test.model


import com.google.gson.annotations.SerializedName

data class TeamModel(
    @SerializedName("data")
    val data: List<Data>
)