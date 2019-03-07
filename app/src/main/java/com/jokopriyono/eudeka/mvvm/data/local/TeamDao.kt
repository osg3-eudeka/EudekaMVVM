package com.jokopriyono.eudeka.mvvm.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.jokopriyono.eudeka.mvvm.model.TeamDetail

@Dao
interface TeamDao {
    @Query("SELECT * FROM team")
    fun getTeams(): MutableList<TeamDetail>

    @Insert
    fun insertTeam(team: MutableList<TeamDetail>)
}