package com.example.mypro1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.mypro1.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

//import com.example.mypro1.adapter.RecyclerView.ViewPagerAdapter

class MainActivity : AppCompatActivity() {
    @SuppressLint("CutPasteId", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewPager2=findViewById<ViewPager2>(R.id.view_pager_2)

//        val viewpager2= findViewById<ViewPager2>(R.id.view_pager_2)
//        val tablayout= findViewById<TabLayout>(R.id.tab_layout)

        viewPager2.adapter= ViewPagerAdapter(this.supportFragmentManager,lifecycle)
//


//        viewpager2.adapter= ViewPagerAdapter(this.supportFragmentManager,lifecycle)
//        TabLayoutMediator(viewpager2){position->
//
//            when(position){
//                0->{
//                    tab.text="First"
//                }
//                1->{
//                    tab.text="Second"
//                }
//                2->{
//                    tab.text="Third"
//                }
//            }
//
//        }.attach()

    }
}