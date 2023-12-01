package com.example.mytravelapp.customFragment.RenderMessage

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.buildSpannedString
import androidx.recyclerview.widget.RecyclerView
import com.example.mytravelapp.R

class CustomAdapterRenderMess(val items: List<OutData>) : RecyclerView.Adapter<CustomAdapterRenderMess.RenderMessViewHolder>(){
    lateinit var context : Context
    inner class RenderMessViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RenderMessViewHolder, position: Int) {
        val imgSender = holder.itemView.findViewById<ImageView>(R.id.imgSender)
        val nameSender = holder.itemView.findViewById<TextView>(R.id.nameSender)
        val contentReciver = holder.itemView.findViewById<TextView>(R.id.txtContent)
        val timeSend = holder.itemView.findViewById<TextView>(R.id.txtTime)

        holder.itemView.apply {
            imgSender.setImageResource(items[position].imgSender)
            nameSender.text = items[position].nameSender
            contentReciver.text = items[position].content
            timeSend.text = items[position].timeReciver




        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RenderMessViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_sender, parent, false)
        return RenderMessViewHolder(view)


    }




}