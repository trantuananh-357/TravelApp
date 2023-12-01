package com.example.mytravelapp.customFragment.renderListImg

import android.app.Activity
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.mytravelapp.MainActivity
import com.example.mytravelapp.R
import com.example.mytravelapp.customFragment.Categories.CustomAdapterCategories
import kotlin.io.path.CopyActionContext

class CustomAdapterRenderImg(val context: Context, private val list: List<OutData>) : RecyclerView.Adapter<CustomAdapterRenderImg.CustomRenderImgViewHolder>() {


    inner class CustomRenderImgViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapterRenderImg.CustomRenderImgViewHolder {



        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_render_img, parent , false)
        return CustomRenderImgViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: CustomAdapterRenderImg.CustomRenderImgViewHolder, position: Int) {
        holder.itemView.apply {

            val img : ImageView = holder.itemView.findViewById(R.id.items_img)

            Glide.with(this)
                .load(list[position].img)
                .apply(RequestOptions().transform(RoundedCorners(25))) // Đặt bán kính bo góc
                .into(img)








        }



    }





}