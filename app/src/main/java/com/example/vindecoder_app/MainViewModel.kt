package com.example.vindecoder_app

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.math.log



@HiltViewModel
class MainViewModel @Inject  constructor(private val repository: MainRepository):ViewModel()
{
    private val _vinDetails = MutableLiveData<VinResponse>()
    val VinDetails:LiveData<VinResponse> = _vinDetails

    fun getVinDetails(vin: String)
    {
        viewModelScope.launch {
            val response =repository.getVinDetails(vin)
            if(response.isSuccessful)
            {
                _vinDetails.value=response.body()
            }
            else
                Log.e("VinDetailsViewModel","Error: ${response.code()}")
        }
    }

}



