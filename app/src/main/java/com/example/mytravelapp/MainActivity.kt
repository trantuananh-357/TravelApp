package com.example.mytravelapp

import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.View
import android.view.ViewTreeObserver
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mytravelapp.databinding.ActivityMainBinding
import com.example.mytravelapp.fragment.homeFragment
import com.example.mytravelapp.fragment.locationFragment
import com.example.mytravelapp.fragment.loveFragment
import com.example.mytravelapp.fragment.messageFragment
import com.example.mytravelapp.fragment.profileFragment
import com.caverock.androidsvg.SVG
import com.caverock.androidsvg.SVGParseException
import com.example.mytravelapp.customFragment.Categories.CustomAdapterCategories
import com.example.mytravelapp.customFragment.Categories.OutData
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView


class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    private val fragmentManager : FragmentManager = supportFragmentManager
    private val home : Fragment = homeFragment()
    private val location : Fragment = locationFragment()
    private val love : Fragment = loveFragment()
    private val mess : Fragment = messageFragment()
    private val profile : Fragment = profileFragment()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding  = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showFragment(home)













        binding.bottomNavigationView.setOnItemSelectedListener{

             when(it.itemId){
                 R.id.home -> {
                        showFragment(home)



                     return@setOnItemSelectedListener true
//                     badgeClear(R.id.home)
                 }
                 R.id.location ->{
                     showFragment(location)
                     return@setOnItemSelectedListener true
//                     badgeClear(R.id.location)



                 }
                 R.id.message ->{
                     showFragment(mess)
                     return@setOnItemSelectedListener true
//                     badgeClear(R.id.message)



                 }
                 R.id.love ->{
                     showFragment(love)
                     return@setOnItemSelectedListener true
//                     badgeClear(R.id.love)

                 }
                 R.id.profile->{
                     showFragment(profile)
                     return@setOnItemSelectedListener true
//                     badgeClear(R.id.profile)



                 }
                 else -> return@setOnItemSelectedListener false



             }

            true










        }






    }

    override fun onBackPressed() {
        // Check if the current fragment is the home fragment
        val currentFragment = fragmentManager.findFragmentById(R.id.frame_layout)
        if (currentFragment is homeFragment) {
            // If it is, handle the back press as needed (e.g., close the app or show a confirmation dialog)
            super.onBackPressed() // Call super to allow the default behavior (closing the app)
        } else {
            // If it's not the home fragment, navigate back as usual
            binding.bottomNavigationView.selectedItemId = R.id.home
        }
    }


    private fun showFragment(selectFragment: Fragment) {
        val transaction : FragmentTransaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, selectFragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }

//    private fun hideNavigationBar() {
//        window.decorView.sys
//            (View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
//                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
//                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
//                    View.SYSTEM_UI_FLAG_FULLSCREEN or
//                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY)
//    }
//    private fun showNavigationBar() {
//        window.decorView.systemUiVisibility =
//            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
//                    View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
//                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
//    }

//    private fun badgeSetup(id: Int, alerts: Int ){
//        val badge: BadgeDrawable = binding.bottomNavigationView.getOrCreateBadge(id)
//        badge.isVisible= true
//        badge.number = alerts
//
//    }
//    private fun badgeClear(id: Int){
//        val badgeDrawable : BadgeDrawable = binding.bottomNavigationView.getOrCreateBadge(id)
//        if(badgeDrawable != null){
//            badgeDrawable.isVisible = false
//            badgeDrawable.clearNumber()
//
//        }
//    }













}