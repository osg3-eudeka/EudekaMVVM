package com.jokopriyono.eudeka.mvvm.data

import com.jokopriyono.eudeka.mvvm.model.Team

interface TeamDataSource {
    interface GetTeamsCallback {
        fun onTeamLoaded(data: Team)
        fun onDataNotAvailable(message: String)
    }

    fun getListTeams(getTeamsCallback: GetTeamsCallback)
}