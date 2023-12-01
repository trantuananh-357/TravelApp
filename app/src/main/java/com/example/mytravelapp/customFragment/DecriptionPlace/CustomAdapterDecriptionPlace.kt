package com.example.mytravelapp.customFragment.DecriptionPlace

import android.app.Activity
import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mytravelapp.MainActivity
import com.example.mytravelapp.R
import com.example.mytravelapp.customFragment.topTrip.CustomAdapterTopTrip
import org.w3c.dom.Text

class CustomAdapterDecriptionPlace( val list: List<OutData>) : RecyclerView.Adapter<CustomAdapterDecriptionPlace.DecriptionViewHolder>() {



    inner class DecriptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    override fun getItemCount(): Int {
        return 1
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapterDecriptionPlace.DecriptionViewHolder {



        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_decription_place_recom, parent , false)
        return DecriptionViewHolder(view)
    }




    override fun onBindViewHolder(holder: DecriptionViewHolder, position: Int) {

        var img = holder.itemView.findViewById<ImageView>(R.id.imgViewDersc)
        var namePlace = holder.itemView.findViewById<TextView>(R.id.txtNamePlaceDesc)
        var vote = holder.itemView.findViewById<TextView>(R.id.txtVoteDesc)
        var desc = holder.itemView.findViewById<TextView>(R.id.txtDesc)
        var imgUserReview = holder.itemView.findViewById<ImageView>(R.id.imgUserReview)
        val nameUserReview  = holder.itemView.findViewById<TextView>(R.id.nameUserReview)
        val timeUserReview  = holder.itemView.findViewById<TextView>(R.id.timeReview)

        holder.itemView.apply {

            img.setImageResource(list[position].img)
            namePlace.text =  list[position].namePlace
            vote.text = list[position].vote
            desc.text = list[position].decriptionPlace
            imgUserReview.setImageResource(list[position].imgReviewer)
            nameUserReview.text = list[position].nameReview
            timeUserReview.text = list[position].time








        }
    }




}