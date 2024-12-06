package com.example.mypro1

import com.example.mypro1.fragements.MovieFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.mypro1.fragements.AccountFragment
import com.example.mypro1.fragements.HomeFragment
//import com.example.mypro1.fragements.com.example.mypro1.fragements.MovieFragment
import com.example.mypro1.fragements.SearchFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class home_activity : AppCompatActivity() {
    private lateinit var navbottom:BottomNavigationView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navbottom=findViewById(R.id.home_bottom_nav_bar)

        navbottom.setOnItemSelectedListener { menuItem->
            when(menuItem.itemId){
                R.id.home->{
                    replaceFragement(HomeFragment())
                    true
                }
                R.id.searchbar->{
                    replaceFragement(SearchFragment())
                    true
                }
                R.id.movie->{
                    replaceFragement(MovieFragment())
                    true
                }
                R.id.account->{
                    replaceFragement(AccountFragment())
                    true
                }
                else->false
            }

        }
            replaceFragement(HomeFragment())
    }

    private fun replaceFragement(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit()
    }

}