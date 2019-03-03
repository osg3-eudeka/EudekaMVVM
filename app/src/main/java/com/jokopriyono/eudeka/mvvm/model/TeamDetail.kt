package com.jokopriyono.eudeka.mvvm.model

import com.google.gson.annotations.SerializedName

data class TeamDetail(
    @SerializedName("strTeam")
    var teamName: String,
    @SerializedName("strTeamBadge")
    var teamLogo: String
)