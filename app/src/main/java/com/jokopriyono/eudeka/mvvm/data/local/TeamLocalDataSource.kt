package com.jokopriyono.eudeka.mvvm.data.local

import android.content.Context
import com.jokopriyono.eudeka.mvvm.data.TeamDataSource
import com.jokopriyono.eudeka.mvvm.model.Team
import com.jokopriyono.eudeka.mvvm.model.TeamDetail

class TeamLocalDataSource(context: Context) : TeamDataSource {
    private var teamDao: TeamDao? = TeamDatabase.getInstance(context)?.teamDao()
    override fun getListTeams(getTeamsCallback: TeamDataSource.GetTeamsCallback) {

        Thread(
            Runnable {
                teamDao?.let {
                    if (it.getTeams().isEmpty()) {
                        getTeamsCallback.onDataNotAvailable("Data in DB Empty")
                    } else {
                        val teams = Team(it.getTeams())
                        getTeamsCallback.onTeamLoaded(teams)
                    }
                }
            }
        ).start()
    }

    fun saveDataTeam(team: MutableList<TeamDetail>) {
        Thread(
            Runnable {
                teamDao?.insertTeam(team)
            }
        ).start()
    }
}