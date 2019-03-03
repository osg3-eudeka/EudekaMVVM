package com.jokopriyono.eudeka.mvvm.view.team

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import com.jokopriyono.eudeka.mvvm.Injection
import com.jokopriyono.eudeka.mvvm.R
import com.jokopriyono.eudeka.mvvm.model.TeamDetail
import com.jokopriyono.eudeka.mvvm.viewmodel.TeamViewModel
import kotlinx.android.synthetic.main.activity_team.*

class TeamActivity : AppCompatActivity(), TeamNavigator {
    private lateinit var teamViewModel: TeamViewModel
    private lateinit var teamAdapter: TeamAdapter
    private var data: MutableList<TeamDetail> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)

        teamViewModel = TeamViewModel(Injection.provideTeamRepository(this), this)
        teamViewModel.setNavigator(this)
        teamViewModel.getListTeam()

        initAdapter()
    }

    private fun initAdapter() {
        teamAdapter = TeamAdapter(data)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = teamAdapter
    }

    override fun loadListTeam(listTeam: MutableList<TeamDetail>) {
        data.addAll(listTeam)
        teamAdapter.notifyDataSetChanged()
    }

    override fun errorLoadTeam(message: String) {
        Log.e("ERROR", message)
    }
}
