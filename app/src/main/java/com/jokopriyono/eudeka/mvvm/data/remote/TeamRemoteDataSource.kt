package com.jokopriyono.eudeka.mvvm.data.remote

import com.jokopriyono.eudeka.mvvm.data.TeamDataSource
import com.jokopriyono.eudeka.mvvm.model.Team
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TeamRemoteDataSource : TeamDataSource, Callback<Team> {
    private val apiInterface = ApiClient.getClient().create(ApiInterface::class.java)
    private lateinit var callBack: TeamDataSource.GetTeamsCallback

    override fun getListTeams(getTeamsCallback: TeamDataSource.GetTeamsCallback) {
        callBack = getTeamsCallback
        val call = apiInterface.getAllTeams("English Premier League")
        call.enqueue(this)
    }

    override fun onResponse(call: Call<Team>, response: Response<Team>) {
        response.body()?.let { callBack.onTeamLoaded(it) }
    }

    override fun onFailure(call: Call<Team>, t: Throwable) {
        callBack.onDataNotAvailable(t.localizedMessage)
    }
}