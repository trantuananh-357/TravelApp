package com.example.mytravelapp.customFragment.Categories

import android.content.Context
import android.content.res.Resources
import android.graphics.PorterDuff
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.mytravelapp.R
class CustomAdapterCategories(private val items: List<OutData>) : RecyclerView.Adapter<CustomAdapterCategories.CategoriesViewHolder>() {
    lateinit var context : Context

    var flag : Boolean =  false

    inner class CategoriesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        context = parent.context



        val view = LayoutInflater.from(parent.context).inflate(R.layout.fragment_categories, parent , false)
        return CategoriesViewHolder(view)
    }
    override fun getItemCount(): Int {

        return items.size
    }


    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val img : ImageView = holder.itemView.findViewById(R.id.imgCategories)
        val title : TextView = holder.itemView.findViewById(R.id.titleCategories)
        val active_background =  holder.itemView.findViewById<LinearLayout>(R.id.layout_toggle)
        val activ_background_icon = holder.itemView.findViewById<LinearLayout>(R.id.layout_background_icon)
        val drawable : Drawable = img.drawable



        holder.itemView.apply {
                img.setImageResource(items[position].img)
                title.text = items[position].title


        }



        setButtonActive(flag, img, drawable, active_background, activ_background_icon)

        holder.itemView.setOnClickListener{
            setButtonActive(flag, img, drawable, active_background, activ_background_icon)

        }







    }
    private fun getDrawableName(drawableId: Int): String {
        return try {
            context.resources.getResourceEntryName(drawableId)
        } catch (e: Resources.NotFoundException) {
            "Not found"
        }
    }


    private fun setButtonActive(isActive : Boolean, active_img : ImageView, drawable : Drawable, active_background : LinearLayout, activ_background_icon : LinearLayout){
        if(isActive){
            flag = false
            active_background.setBackgroundResource(R.drawable.background_categories )
            activ_background_icon.setBackgroundResource(R.drawable.background_icon_active)

            // Xử lí tố màu viền ngoài cho icon
            val color = ContextCompat.getColor(context, R.color.white) // Thay "your_color" bằng mã màu của bạn
            val wrappedDrawable = DrawableCompat.wrap(drawable)
            DrawableCompat.setTint(wrappedDrawable, color)
            DrawableCompat.setTintMode(wrappedDrawable, PorterDuff.Mode.SRC_IN)

            // Đặt Drawable đã được thay đổi màu vào ImageView
            active_img.setImageDrawable(wrappedDrawable)

        }
        else{
            flag = true

            active_background.setBackgroundResource(R.drawable.background_button_toggle_inactive )
            activ_background_icon.setBackgroundResource(com.google.android.material.R.color.mtrl_btn_transparent_bg_color)

            // Xử lí tố màu viền ngoài cho icon
            val color = ContextCompat.getColor(context, R.color.color_btn) // Thay "your_color" bằng mã màu của bạn
            val wrappedDrawable = DrawableCompat.wrap(drawable)
            DrawableCompat.setTint(wrappedDrawable, color)
            DrawableCompat.setTintMode(wrappedDrawable, PorterDuff.Mode.SRC_IN)

            // Đặt Drawable đã được thay đổi màu vào ImageView
            active_img.setImageDrawable(wrappedDrawable)

        }
    }
























}