package com.example.mytravelapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytravelapp.R
import com.example.mytravelapp.customFragment.RenderMessage.CustomAdapterRenderMess
import com.example.mytravelapp.customFragment.RenderMessage.OutData


class messageFragment : Fragment() {

    private lateinit var customAdapterRenderMess: CustomAdapterRenderMess
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_message, container, false)

        val RecyclerMess : RecyclerView = view.findViewById(R.id.renderRecyclerMess)
        val listMess = mutableListOf<OutData>()

        listMess.add(OutData(R.drawable.user2, "ITA", "See you next week!", "10:30 PM"))
        listMess.add(OutData(R.drawable.user3, "Vũ", "God Night", "10:30 PM"))
        listMess.add(OutData(R.drawable.user4, "Shawn Jobs", "Next", "06:30 PM"))
        listMess.add(OutData(R.drawable.user5, "ITA", "See you next week!", "19:30 PM"))
        listMess.add(OutData(R.drawable.user1, "ITA", "See you next week!", "10:30 PM"))
        listMess.add(OutData(R.drawable.user2, "ITA", "See you next week!", "10:30 PM"))
        listMess.add(OutData(R.drawable.user3, "ITA", "See you next week!", "10:30 PM"))
        listMess.add(OutData(R.drawable.user4, "ITA", "See you next week!", "10:30 PM"))
        listMess.add(OutData(R.drawable.user5, "ITA", "See you next week!", "10:30 PM"))
        listMess.add(OutData(R.drawable.user1, "ITA", "See you next week!", "10:30 PM"))
        listMess.add(OutData(R.drawable.user2, "ITA", "See you next week!", "10:30 PM"))

        customAdapterRenderMess = CustomAdapterRenderMess(listMess)
        RecyclerMess.adapter = customAdapterRenderMess
        RecyclerMess.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false )



        val backPress : ImageView = view.findViewById(R.id.iconBackpressMess)
        backPress.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }


        return view

    }



}