package com.example.vindecoder_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vindecoder_app.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel=ViewModelProvider(this).get(MainViewModel::class.java)
        binding.submitBtn.setOnClickListener{
            val vin=binding.vinEditText.text.toString()
            viewModel.getVinDetails(vin)
            binding.recyclerview.layoutManager = LinearLayoutManager(this)

        }
        viewModel.VinDetails.observe(this){ vinDetails->
            val vinDetails=vinDetails.Results.get(0)
//            binding.vinDetailsTextView.text="VIN: ${vinDetails.VIN}\n" +
//                    "Vehicle Type: ${vinDetails.VehicleType}\n" +
//                    "Plant City: ${vinDetails.PlantCity}\n" +
//                    "Plant Company Name: ${vinDetails.PlantCompanyName}\n" +
//                    "Plant Country: ${vinDetails.PlantCountry}\n" +
//                    "Plant State: ${vinDetails.PlantState}\n" +
//                    "Make: ${vinDetails.Make}\n"


            // getting the recyclerview by its id


            // this creates a vertical layout Manager



            // This will pass the ArrayList to our Adapter
            val adapter = CustomAdapter(vinDetails)

            // Setting the Adapter with the recyclerview
            binding.recyclerview.adapter = adapter
        }
    }
}