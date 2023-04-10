package com.example.vindecoder_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.vindecoder_app.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: VinDetailsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel=ViewModelProvider(this).get(VinDetailsViewModel::class.java)
        binding.submitBtn.setOnClickListener{
            val vin=binding.vinEditText.text.toString()
            viewModel.getVinDetails(vin)
        }
        viewModel.vinDetails.observe(this){ vinDetails->
            val vinDetails=vinDetails.Results.get(0)
            binding.vinDetailsTextView.text="VIN: ${vinDetails.VIN}\n" +
                    "Vehicle Type: ${vinDetails.VehicleType}\n" +
                    "Plant City: ${vinDetails.PlantCity}\n" +
                    "Plant Company Name: ${vinDetails.PlantCompanyName}\n" +
                    "Plant Country: ${vinDetails.PlantCountry}\n" +
                    "Plant State: ${vinDetails.PlantState}\n" +
                    "Make: ${vinDetails.Make}\n"

        }
    }
}