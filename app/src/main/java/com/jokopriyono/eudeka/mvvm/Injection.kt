package com.jokopriyono.eudeka.mvvm

import android.content.Context
import com.jokopriyono.eudeka.mvvm.data.TeamRepository
import com.jokopriyono.eudeka.mvvm.data.local.TeamLocalDataSource
import com.jokopriyono.eudeka.mvvm.data.remote.TeamRemoteDataSource

class Injection {
    companion object {
        fun provideTeamRepository(context: Context): TeamRepository {
            return TeamRepository(TeamRemoteDataSource(), TeamLocalDataSource(context))
        }
    }
}