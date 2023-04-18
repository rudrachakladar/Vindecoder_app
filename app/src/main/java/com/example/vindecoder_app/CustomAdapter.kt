package com.example.vindecoder_app

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(private val mList: com.example.vindecoder_app.Result) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_view_design, parent, false)

        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val result = mList
        holder.vin.text=result.VIN
        holder.vehicleType.text=result.VehicleType
        holder.plantCity.text=result.PlantCity
        holder.plantCompanyName.text=result.PlantCompanyName
        holder.plantCountry.text=result.PlantCountry
        holder.plantState.text=result.PlantState
        holder.make.text=result.Make
        holder.model.text=result.Model
        holder.modelYear.text=result.ModelYear

        // sets the image to the imageview from

    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return 1
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val vin:TextView=itemView.findViewById(R.id.vinValue)
        val vehicleType:TextView=itemView.findViewById(R.id.vehicleTypeValue)
        val plantCity:TextView=itemView.findViewById(R.id.plantCityValue)
        val plantCompanyName:TextView=itemView.findViewById(R.id.plantCompanyNameValue)
        val plantCountry:TextView=itemView.findViewById(R.id.plantCountryValue)
        val plantState:TextView=itemView.findViewById(R.id.plantStateValue)
        val make:TextView=itemView.findViewById(R.id.makeValue)
        val model:TextView=itemView.findViewById(R.id.modelValue)
        val modelYear:TextView=itemView.findViewById(R.id.modelYearValue)
    }
}