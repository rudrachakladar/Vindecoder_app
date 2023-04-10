package com.example.vindecoder_app

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    companion object
    {
        private val BASE_URL="https://vpic.nhtsa.dot.gov/api/vehicles/"
        fun getInstance():Retrofit{
            return  Retrofit.Builder()
                .baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create())
                .build()

        }
    }
}