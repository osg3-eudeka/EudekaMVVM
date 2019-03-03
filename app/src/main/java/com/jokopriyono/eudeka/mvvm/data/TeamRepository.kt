package com.jokopriyono.eudeka.mvvm.data

import com.jokopriyono.eudeka.mvvm.data.local.TeamLocalDataSource
import com.jokopriyono.eudeka.mvvm.data.remote.TeamRemoteDataSource
import com.jokopriyono.eudeka.mvvm.model.Team

class TeamRepository(
    private val teamRemoteDataSource: TeamRemoteDataSource,
    private val teamLocalDataSource: TeamLocalDataSource
) :
    TeamDataSource {

    override fun getListTeams(getTeamsCallback: TeamDataSource.GetTeamsCallback) {
        teamLocalDataSource.getListTeams(
            object : TeamDataSource.GetTeamsCallback {
                override fun onTeamLoaded(data: Team) {
                    getTeamsCallback.onTeamLoaded(data)
                }

                override fun onDataNotAvailable(message: String) {
                    getTeamsFromRemoteDataSource(getTeamsCallback)
                }

            }
        )
    }

    private fun getTeamsFromRemoteDataSource(callback: TeamDataSource.GetTeamsCallback?) {
        teamRemoteDataSource.getListTeams(
            object : TeamDataSource.GetTeamsCallback {
                override fun onTeamLoaded(data: Team) {
                    // insert to DB
                    teamLocalDataSource.saveDataTeam(data.teams)
                    callback?.onTeamLoaded(data)
                }

                override fun onDataNotAvailable(message: String) {
                    callback?.onDataNotAvailable(message)
                }

            }
        )
    }
}