package com.jokopriyono.eudeka.mvvm.data.local

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import com.jokopriyono.eudeka.mvvm.model.TeamDetail

@Dao
interface TeamDao {
    @Query("SELECT * FROM team")
    fun getTeams(): MutableList<TeamDetail>

    @Insert
    fun insertTeam(team: MutableList<TeamDetail>)
}