package com.jokopriyono.eudeka.mvvm.view.team

import com.jokopriyono.eudeka.mvvm.model.TeamDetail

interface TeamNavigator {
    fun loadListTeam(listTeam: MutableList<TeamDetail>)
    fun errorLoadTeam(message: String)
}