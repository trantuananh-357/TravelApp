package com.example.mytravelapp.fragment

import android.graphics.Color
import android.graphics.RenderEffect
import android.graphics.Shader
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytravelapp.R
import com.example.mytravelapp.customFragment.DecriptionPlace.CustomAdapterDecriptionPlace
import com.example.mytravelapp.customFragment.DecriptionPlace.OutData


class descriptionFragment : Fragment() {
    lateinit var customAdapterDecriptionPlace : CustomAdapterDecriptionPlace

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?) : View?{

        val view = inflater.inflate(R.layout.fragment_detail_location, container, false)



        val backGroundColor = Color.argb(209,149,91, 1)
        view.findViewById<LinearLayout>(R.id.backGround_img_blur).setBackgroundColor(backGroundColor)

        val linearLayout : LinearLayout = view.findViewById(R.id.backGround_img_blur)
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            linearLayout.setRenderEffect(
                RenderEffect.createBlurEffect(
                    50f,
                    50f,
                    Shader.TileMode.MIRROR
                )
            )
        }





        val list = mutableListOf<OutData>()
        list.add(OutData(
            R.drawable.location_6, "King  + Duke", "4.5" , "One of EATER National and Atlanta Magazine’s most anticipated new openings of 2013.This new restaurant by Ford Fry and Rocket Farm, designed by Meyer Davis and NO Architecture, is located at the corner of West Paces Ferry",
            R.drawable.user1, "Miley Erikson", "2 weeks ago"))
        list.add(OutData(
            R.drawable.location_6, "King  + Duke", "4.5" , "One of EATER National and Atlanta Magazine’s most anticipated new openings of 2013.This new restaurant by Ford Fry and Rocket Farm, designed by Meyer Davis and NO Architecture, is located at the corner of West Paces Ferry",
            R.drawable.user1, "Miley Erikson", "2 weeks ago"))
        list.add(OutData(
            R.drawable.location_6, "King  + Duke", "4.5" , "One of EATER National and Atlanta Magazine’s most anticipated new openings of 2013.This new restaurant by Ford Fry and Rocket Farm, designed by Meyer Davis and NO Architecture, is located at the corner of West Paces Ferry",
            R.drawable.user1, "Miley Erikson", "2 weeks ago"))


        var listDesc = view.findViewById<RecyclerView>(R.id.listViewDesc)
        listDesc.isNestedScrollingEnabled = false
        customAdapterDecriptionPlace = CustomAdapterDecriptionPlace(list)

        listDesc.adapter = customAdapterDecriptionPlace
        listDesc.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)



        val backPress : ImageView = view.findViewById(R.id.icon_backpres)
        backPress.setOnClickListener{
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.frame_layout, locationFragment())
                .addToBackStack(null)
                .commit()
        }


        return view

    }




}
