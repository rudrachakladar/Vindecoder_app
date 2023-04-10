package com.example.vindecoder_app

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Vehicleapi {
    @GET("DecodeVinValues/{vin}?format=json")
    suspend fun getVinDetails(@Path ("vin") id:String):Response<VinDetails>


}