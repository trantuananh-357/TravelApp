package com.example.mytravelapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytravelapp.R
import com.example.mytravelapp.customFragment.RenderMessage.CustomAdapterRenderMess
import com.example.mytravelapp.customFragment.savedTrips.CustomAdapterSavedStrip
import com.example.mytravelapp.customFragment.savedTrips.OutData

class loveFragment : Fragment() {

    private lateinit var customAdapterSavedStrip: CustomAdapterSavedStrip
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = layoutInflater.inflate(R.layout.fragment_love, container, false)
        val recyclerEvent : RecyclerView = view.findViewById(R.id.renderRecyclerEvents)
        val recyclerPackage :  RecyclerView = view.findViewById(R.id.renderRecyclerPackages)

        val listEvent = mutableListOf<OutData>()
        val listPackages = mutableListOf<OutData>()


        listEvent.add(OutData(R.drawable.location_6, "RedFish Lake" , "Idaho",  "40" , "3 day visit", "4.5"))
        listEvent.add(OutData(R.drawable.location_5, "RedFish Lake" , "Idaho",  "40" , "3 day visit", "4.5"))
        listEvent.add(OutData(R.drawable.location_4, "RedFish Lake" , "Idaho",  "40" , "3 day visit", "4.5"))
        listEvent.add(OutData(R.drawable.location_3, "RedFish Lake" , "Idaho",  "40" , "3 day visit", "4.5"))

        customAdapterSavedStrip = CustomAdapterSavedStrip(listEvent)

        recyclerEvent.adapter = customAdapterSavedStrip
        recyclerEvent.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)



        listPackages.add(OutData(R.drawable.location_6, "RedFish Lake" , "Idaho",  "40" , "3 day visit", "4.5"))
        listPackages.add(OutData(R.drawable.location_5, "RedFish Lake" , "Idaho",  "40" , "3 day visit", "4.5"))
        listPackages.add(OutData(R.drawable.location_3, "RedFish Lake" , "Idaho",  "40" , "3 day visit", "4.5"))
        listPackages.add(OutData(R.drawable.location_2, "RedFish Lake" , "Idaho",  "40" , "3 day visit", "4.5"))
        listPackages.add(OutData(R.drawable.location_4, "RedFish Lake" , "Idaho",  "40" , "3 day visit", "4.5"))
        listPackages.add(OutData(R.drawable.location_3, "RedFish Lake" , "Idaho",  "40" , "3 day visit", "4.5"))
        customAdapterSavedStrip = CustomAdapterSavedStrip(listPackages)

        recyclerPackage.adapter = customAdapterSavedStrip
        recyclerPackage.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false)





        return view
    }


}