package com.example.mytravelapp.customFragment.slideImg



import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.mytravelapp.R
import com.google.android.gms.common.internal.Objects
import org.w3c.dom.Text
import java.util.*

class CustomAdapterSlideImg(val context: Context,  val items: List<Outdata>)  : PagerAdapter(){

//
//        val textPlace = itemView.findViewById<TextView>(R.id.txtPlace)
//        val textFar = itemView.findViewById<TextView>(R.id.txtFar)
//        val img = itemView.findViewById<ImageView>(R.id.imgPlace)
//        fun blind(outdata: Outdata){
//            textPlace.text = outdata.place
//            textFar.text = outdata.far
//            img.setImageResource(outdata.img)
//        }


    override fun getCount(): Int {
        return items.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
      return view ===`object` as ConstraintLayout
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val layoutInflater : LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater


        val view: View = layoutInflater.inflate(R.layout.fragment_slide_img, container, false)

        val img : ImageView = view.findViewById(R.id.imgPlace) as ImageView
        val namePlace : TextView = view.findViewById(R.id.txtPlace) as TextView
        val farPlace : TextView = view.findViewById(R.id.txtFar) as TextView

        val sliderData: Outdata = items.get(position)
        namePlace.text = sliderData.place
        farPlace.text = sliderData.far
        img.setImageResource(sliderData.img)

        // on below line we are adding our view to container.
        container.addView(view)

        // on below line we are returning our view.
        return view




    }
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }








}