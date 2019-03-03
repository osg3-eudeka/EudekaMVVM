package com.jokopriyono.eudeka.mvvm.viewmodel

import android.content.Context
import com.jokopriyono.eudeka.mvvm.data.TeamDataSource
import com.jokopriyono.eudeka.mvvm.data.TeamRepository
import com.jokopriyono.eudeka.mvvm.model.Team
import com.jokopriyono.eudeka.mvvm.view.team.TeamNavigator

class TeamViewModel(val teamRepository: TeamRepository, context: Context) {
    private lateinit var teamNavigator: TeamNavigator

    fun setNavigator(teamNavigator: TeamNavigator) {
        this.teamNavigator = teamNavigator
    }

    fun getListTeam() {
        teamRepository.getListTeams(
            object : TeamDataSource.GetTeamsCallback {
                override fun onTeamLoaded(data: Team) {
                    teamNavigator.loadListTeam(data.teams)
                }

                override fun onDataNotAvailable(message: String) {
                    teamNavigator.errorLoadTeam(message)
                }

            }
        )
    }
}