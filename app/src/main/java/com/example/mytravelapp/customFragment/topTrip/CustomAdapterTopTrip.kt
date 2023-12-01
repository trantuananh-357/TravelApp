package com.example.mytravelapp.customFragment.topTrip

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mytravelapp.LakeViewActivity
import com.example.mytravelapp.LoginActivity
import com.example.mytravelapp.R
import org.w3c.dom.Text

class CustomAdapterTopTrip(private val items: List<Outdata>) : RecyclerView.Adapter<CustomAdapterTopTrip.TopTripViewHolder>() {
    lateinit var context : Context


    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }
    inner class TopTripViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopTripViewHolder {
        context = parent.context



        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_toptrip, parent , false)
        return TopTripViewHolder(view)
    }
    override fun getItemCount(): Int {

        return items.size
    }


    override fun onBindViewHolder(holder: TopTripViewHolder, position: Int) {
        val img : ImageView = holder.itemView.findViewById(R.id.img_place)
        val vote :TextView = holder.itemView.findViewById(R.id.txtVote)
        val namePlace : TextView  =holder.itemView.findViewById(R.id.txtNamePlace)
        val location : TextView =  holder.itemView.findViewById(R.id.textLocation)
        val cost : TextView = holder.itemView.findViewById(R.id.txtCost)
        holder.itemView.apply {
            img.setImageResource(items[position].img)
            vote.text = items[position].vote
            namePlace.text = items[position].namePlace
            location.text = items[position].location
            cost.text = "$"+  items[position].cost



        }


        holder.itemView.findViewById<ImageView>(R.id.iconLove).setOnClickListener {

            val iconVote: ImageView = holder.itemView.findViewById(R.id.iconLove)




  // Thay "your_color" bằng mã màu của bạn

            iconVote.setImageResource(R.drawable.icon_love_active)
//
        }




        holder.itemView.setOnClickListener{
            val intent = Intent(context, LakeViewActivity::class.java)
            context.startActivity(intent)

        }






    }


}























