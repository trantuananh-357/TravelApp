package com.example.mytravelapp


import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.mytravelapp.customFragment.renderListImg.CustomAdapterRenderImg
import com.example.mytravelapp.customFragment.renderListImg.OutData
import com.example.mytravelapp.databinding.ActivityMainBinding
private lateinit var binding : ActivityMainBinding

class LakeViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lakeview)
        binding = ActivityMainBinding.inflate(layoutInflater)


        var list = mutableListOf<OutData>()

        list.add(OutData(R.drawable.location_3))
        list.add(OutData(R.drawable.location_3))
        list.add(OutData(R.drawable.location_3))
        list.add(OutData(R.drawable.location_3))
        val adapter = CustomAdapterRenderImg(this,  list)

        var recyclerRenderImg: RecyclerView = findViewById(R.id.list_img)
        recyclerRenderImg.adapter = adapter
        recyclerRenderImg.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false )


        val backPressBtn : ImageView = findViewById(R.id.icon_backpres)
        val loveBtn : ImageView = findViewById(R.id.loveBtn)

        backPressBtn.setOnClickListener{
            onBackPressedDispatcher.onBackPressed()
        }
        backPressBtn.setOnHoverListener{view, motionEvent->
            when(motionEvent.action){
                MotionEvent.ACTION_HOVER_ENTER ->{
                    backPressBtn.setBackgroundColor(R.drawable.background_btn_back_press)
                }
                MotionEvent.ACTION_HOVER_EXIT -> {
                    // Sự kiện khi di chuột ra khỏi ImageView
                    backPressBtn.setBackgroundColor(Color.TRANSPARENT)
                }
            }
            true
        }

        loveBtn.setOnClickListener{
            loveBtn.setImageResource(R.drawable.icon_love_active)

        }




















    }




}
