package com.example.mytravelapp.customFragment.groupTrips

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.mytravelapp.R

class CustomAdapterGroupTrip (val items: List<OutDataGroupTrip>) : RecyclerView.Adapter<CustomAdapterGroupTrip.GroupTripViewHolder>() {
    var currentProgess : Int = 0
    lateinit var progressBar : ProgressBar

    inner class GroupTripViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)


    override fun getItemCount(): Int {
        return 1
    }

    override fun onBindViewHolder(holder: GroupTripViewHolder, position: Int) {
            val imgTrip : ImageView = holder.itemView.findViewById(R.id.imgTrip)
            val nameTrip : TextView = holder.itemView.findViewById(R.id.txtNameTrip)
            val countryTrip : TextView = holder.itemView.findViewById(R.id.txtCountryTrip)
            val locationTrip : TextView = holder.itemView.findViewById(R.id.txtLocationTrip)
            val Count : TextView = holder.itemView.findViewById(R.id.txtCount)

        holder.itemView.apply {
            imgTrip.setImageResource(items[position].imgTrip)
            nameTrip.text = items[position].nameTrip
            countryTrip.text = items[position].countryTip
            locationTrip.text = items[position].locationTrip
            Count.text = items[position].count


        }

        progressBar = holder.itemView.findViewById(R.id.progressBar)
        currentProgess = items[position].percentRate
        progressBar.setProgress(currentProgess)






    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupTripViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_grouptrip, parent, false)
            return GroupTripViewHolder(view)
    }
}