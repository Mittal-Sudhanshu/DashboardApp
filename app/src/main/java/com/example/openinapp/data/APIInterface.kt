package com.example.openinapp.data

import com.example.openinapp.data.models.APIData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface APIInterface{
    @GET("dashboardNew")
    fun getData(@Header ("Authorization")token: String): Call<APIData>
}