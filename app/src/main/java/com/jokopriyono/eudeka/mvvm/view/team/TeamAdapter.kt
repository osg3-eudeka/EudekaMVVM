package com.jokopriyono.eudeka.mvvm.view.team

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jokopriyono.eudeka.mvvm.R
import com.jokopriyono.eudeka.mvvm.model.TeamDetail
import kotlinx.android.synthetic.main.item_team.view.*

class TeamAdapter(private var teams: MutableList<TeamDetail>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_team, viewGroup, false))
    }

    override fun getItemCount(): Int = teams.size

    override fun onBindViewHolder(holder: ViewHolder, pos: Int) {
        holder.bindData(teams[pos])
    }
}

class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    private val txtName = v.txt_team_name

    fun bindData(teamDetail: TeamDetail) {
        txtName.text = teamDetail.teamName
    }
}