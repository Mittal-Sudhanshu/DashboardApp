package com.example.openinapp.repository

import android.content.Context
import com.example.openinapp.data.APIInterface
import com.example.openinapp.data.sharePref.SharedPreference
import com.example.openinapp.network.RetroFitClient

class DataRepository() {

    val retrofitClient= RetroFitClient.instance.
    create(APIInterface::class.java)

    fun getData () = retrofitClient.getData("Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MjU5MjcsImlhdCI6MTY3NDU1MDQ1MH0.dCkW0ox8tbjJA2GgUx2UEwNlbTZ7Rr38PVFJevYcXFI")

}