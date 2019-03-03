package com.jokopriyono.eudeka.mvvm.data.local

import com.jokopriyono.eudeka.mvvm.data.TeamDataSource
import com.jokopriyono.eudeka.mvvm.model.Team
import com.jokopriyono.eudeka.mvvm.model.TeamDetail

class TeamLocalDataSource(private val teamDao: TeamDao) : TeamDataSource {
    override fun getListTeams(getTeamsCallback: TeamDataSource.GetTeamsCallback) {

        Thread(
            Runnable {
                val team = teamDao.getTeams()
                if (team.isEmpty()) {
                    getTeamsCallback.onDataNotAvailable("Data in DB Empty")
                } else {
                    val teams = Team(team)
                    getTeamsCallback.onTeamLoaded(teams)
                }
            }
        ).start()
    }

    fun saveDataTeam(team: MutableList<TeamDetail>) {
        Thread(
            Runnable {
                teamDao.insertTeam(team)
            }
        ).start()
    }
}