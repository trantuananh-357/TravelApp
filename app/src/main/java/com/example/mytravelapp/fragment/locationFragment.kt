package com.example.mytravelapp.fragment
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.ViewPager
import com.example.mytravelapp.R
import com.example.mytravelapp.customFragment.slideImg.CustomAdapterSlideImg
import com.example.mytravelapp.customFragment.slideImg.Outdata
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator

class locationFragment : Fragment(){

        lateinit var viewPager: ViewPager
        lateinit var customAdapterSlideImg: CustomAdapterSlideImg
        lateinit var sliderList: ArrayList<Outdata>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view  = inflater.inflate(R.layout.fragment_location, container, false)

        viewPager  = view.findViewById(R.id.imgRenderViewPage)
        sliderList = ArrayList()
        sliderList.add(Outdata(R.drawable.location_5, "Hà Nội, Việt Nam" , "15 km"))
        sliderList.add(Outdata(R.drawable.location_5, "Hà Nội, Việt Nam" , "15 km"))
        sliderList.add(Outdata(R.drawable.location_5, "Hà Nội, Việt Nam" , "15 km"))
        sliderList.add(Outdata(R.drawable.location_5, "Hà Nội, Việt Nam" , "15 km"))


        customAdapterSlideImg = CustomAdapterSlideImg(requireContext(), sliderList)

        viewPager.adapter = customAdapterSlideImg
        val dotsIndicator = view.findViewById<DotsIndicator>(R.id.dots_indicator)
        dotsIndicator.attachTo(viewPager)









        return view





    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val detailLocation  : LinearLayout = view.findViewById(R.id.detailLocationBtn)
        detailLocation.setOnClickListener{
            switchToFragmentDesc()


        }
    }

    private fun switchToFragmentDesc() {

        // Bắt đầu giao dịch để thay thế FragmentA bằng FragmentB
        val fragmentManager: FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()

        // Thay thế FragmentA bằng FragmentB
        val fragmentDesc = descriptionFragment()
        fragmentTransaction.replace(R.id.frame_layout, fragmentDesc)

        // Thêm transaction vào back stack để có thể quay lại FragmentA khi cần
        fragmentTransaction.addToBackStack(null)

        // Kết thúc giao dịch
        fragmentTransaction.commit()

    }







}