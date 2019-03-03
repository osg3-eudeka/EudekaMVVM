package com.jokopriyono.eudeka.mvvm.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.jokopriyono.eudeka.mvvm.model.TeamDetail

@Database(entities = [TeamDetail::class], version = 1)
abstract class TeamDatabase : RoomDatabase() {
    companion object {
        private var INSTANCE: TeamDatabase? = null
        private val sLock = Object()

        fun getInstance(context: Context): TeamDatabase? {
            synchronized(sLock) {
                INSTANCE?.let {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        TeamDatabase::class.java,
                        "Team.db"
                    ).build()
                }
                return INSTANCE
            }
        }
    }

    abstract fun teamDao(): TeamDao
}