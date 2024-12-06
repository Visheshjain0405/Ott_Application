package com.example.mypro1.fragements

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.mypro1.MainActivity
import com.example.mypro1.R
import com.example.mypro1.login_activity


class ThirdFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_third,container,false)
        val startActivityButton: Button = view.findViewById(R.id.buttonlogin)
        startActivityButton.setOnClickListener {
            // Handle the button click
            startNewActivity()
        }
        return view
    }

    private fun startNewActivity() {
        val intent = Intent(activity, login_activity::class.java)
        startActivity(intent)
    }


}