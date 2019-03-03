package com.jokopriyono.eudeka.mvvm.model

import com.google.gson.annotations.SerializedName

data class Team(
    @SerializedName("teams")
    var teams: MutableList<TeamDetail>
)