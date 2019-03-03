package com.jokopriyono.eudeka.mvvm.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        fun getClient(): Retrofit {
            return Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}