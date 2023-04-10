package com.example.vindecoder_app

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class VinDetailsViewModel : ViewModel() {
    private val _vinDetails =MutableLiveData<VinDetails>()
    val vinDetails: LiveData<VinDetails> = _vinDetails
    val retrofit=RetrofitInstance.getInstance().create(Vehicleapi::class.java)
    @SuppressLint("SuspiciousIndentation")
    fun getVinDetails(vin:String)
    {
        viewModelScope.launch {
       val response= retrofit.getVinDetails(vin)
            if(response.isSuccessful)
            {
              _vinDetails.value=  response.body()
            }
            else
            {
                Log.e("Vindetails","Error ${response.code()}")
            }
        }
    }

}