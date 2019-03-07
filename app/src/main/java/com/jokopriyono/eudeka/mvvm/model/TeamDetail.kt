package com.jokopriyono.eudeka.mvvm.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "team")
data class TeamDetail(
    @PrimaryKey(autoGenerate = true)
    var mId: Int,
    @ColumnInfo(name = "team_name")
    @SerializedName("strTeam")
    var teamName: String,
    @ColumnInfo(name = "team_logo")
    @SerializedName("strTeamBadge")
    var teamLogo: String
)