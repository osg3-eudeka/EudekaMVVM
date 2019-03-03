package com.jokopriyono.eudeka.mvvm.data.remote

import com.jokopriyono.eudeka.mvvm.model.Team
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("api/v1/json/1/search_all_teams.php")
    fun getAllTeams(@Query("l") search: String): Call<Team>

}