package com.example.openinapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetroFitClient{
    private var API_URL="https://api.inopenapp.com/api/v1/"
    val instance:Retrofit by lazy {
        Retrofit.Builder().
        baseUrl(API_URL).
        addConverterFactory(GsonConverterFactory.create()).
        build()

    }
}