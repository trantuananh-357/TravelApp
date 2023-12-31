package com.example.mytravelapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytravelapp.R
import com.example.mytravelapp.customFragment.Categories.CustomAdapterCategories
import com.example.mytravelapp.customFragment.Categories.OutData
import com.example.mytravelapp.customFragment.topTrip.CustomAdapterTopTrip
import com.example.mytravelapp.customFragment.topTrip.Outdata
import com.example.mytravelapp.customFragment.groupTrips.CustomAdapterGroupTrip
import com.example.mytravelapp.customFragment.groupTrips.OutDataGroupTrip


//private lateinit var _binding: FragmentHomeBinding

class homeFragment : Fragment() {







    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {






        val view = inflater.inflate(R.layout.fragment_home, container, false)



        //Render categories
        val items = mutableListOf<OutData>()
        items.add(OutData(R.drawable.mountain_solid, "Mountains"))
        items.add(OutData(R.drawable.water_solid, "Mountains"))
        items.add(OutData(R.drawable.tree_solid, "Mountains"))
        val adapter = CustomAdapterCategories(items)
        var recyclerViewCategories : RecyclerView = view.findViewById(R.id.viewRenderCategories)
        recyclerViewCategories.adapter = adapter
        recyclerViewCategories.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)



        //Render top trip
        val items_topTrip = mutableListOf<Outdata>()
        items_topTrip.add(Outdata(R.drawable.location_4, "4.5",  "RedFish Lake", "Idaho", "40"))
        items_topTrip.add(Outdata(R.drawable.location_3, "4.5",  "RedFish Lake", "Idaho", "40"))
        items_topTrip.add(Outdata(R.drawable.location_3, "4.5",  "RedFish Lake", "Idaho", "40"))
        items_topTrip.add(Outdata(R.drawable.location_3, "4.5",  "RedFish Lake", "Idaho", "40"))

        val adapterTopTrip = CustomAdapterTopTrip(items_topTrip)
        var recyclerViewTopTrip : RecyclerView = view.findViewById(R.id.viewRenderTopTrip)
        recyclerViewTopTrip.adapter = adapterTopTrip
        recyclerViewTopTrip.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)




        //renderGroupTrip

        val items_GroupTrip = mutableListOf<OutDataGroupTrip>()
        val listTraveler = mutableListOf<Int>()

        items_GroupTrip.add(OutDataGroupTrip(R.drawable.location_4, "Lake View", "Việt Nam", "Hà Nội",listTraveler, "1200", 80))
        items_GroupTrip.add(OutDataGroupTrip(R.drawable.location_3, "Lake View", "Việt Nam", "Hà Nội",listTraveler, "1200", 80))
        items_GroupTrip.add(OutDataGroupTrip(R.drawable.location_3, "Lake View", "Việt Nam", "Hà Nội",listTraveler, "1200", 80))
        items_GroupTrip.add(OutDataGroupTrip(R.drawable.location_3, "Lake View", "Việt Nam", "Hà Nội",listTraveler, "1200", 80))

        val adapterGroupTrip = CustomAdapterGroupTrip(items_GroupTrip)
        var recyclerViewGroupTrip : RecyclerView = view.findViewById(R.id.viewRenderGroupTrip)
        recyclerViewGroupTrip.adapter = adapterGroupTrip
        recyclerViewGroupTrip.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)











        return view
    }








}


