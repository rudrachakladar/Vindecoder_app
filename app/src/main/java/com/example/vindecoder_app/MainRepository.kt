package com.example.vindecoder_app

import retrofit2.Response
import javax.inject.Inject

class MainRepository @Inject constructor(val apiService: Vehicleapi)
{
    suspend fun getVinDetails(vin: String):Response<VinResponse>{
        return apiService.getVinDetails(vin)
    }
}