package com.example.mytravelapp.customFragment.savedTrips

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.mytravelapp.R
import org.w3c.dom.Text

class CustomAdapterSavedStrip(val items: List<OutData>) : RecyclerView.Adapter<CustomAdapterSavedStrip.SavedTripsViewHolder>() {

    lateinit var context: Context
    inner class SavedTripsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: SavedTripsViewHolder, position: Int) {
        val nameTrip = holder.itemView.findViewById<TextView>(R.id.txtNameTrip)
        val locationTrip = holder.itemView.findViewById<TextView>(R.id.textLocationTrip)
        val cost = holder.itemView.findViewById<TextView>(R.id.costTrip)
        val timeStay = holder.itemView.findViewById<TextView>(R.id.txtTimeTrip)
        val vote = holder.itemView.findViewById<TextView>(R.id.txtVoteTrip)

        holder.itemView.apply {

            val img = holder.itemView.findViewById<ImageView>(R.id.imgSaveTrip)
            Glide.with(this)
                .load(items[position].img)
                .apply(RequestOptions().transform(RoundedCorners(80))) // Đặt bán kính bo góc
                .into(img)

            nameTrip.text = items[position].namePlace
            locationTrip.text = items[position].location
            cost.text = "$" + items[position].cost
            timeStay.text = "/" + items[position].timeStay
            vote.text = items[position].vote







        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SavedTripsViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_save_trips, parent, false)
        return  SavedTripsViewHolder(view)
    }
}