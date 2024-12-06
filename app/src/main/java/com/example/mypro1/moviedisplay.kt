package com.example.mypro1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class moviedisplay : AppCompatActivity() {

    private lateinit var movietitle: TextView
    private lateinit var movieimage: ImageView
    private lateinit var moviebackground: ImageView
    private lateinit var moviebutton: Button
    private lateinit var moviedescription: TextView
    private lateinit var movieLink:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_moviedisplay)

        // Initialize views
        movietitle = findViewById(R.id.movie_title)
        movieimage = findViewById(R.id.movie_image)
//        moviebackground = findViewById(R.id.movie_background)
        moviebutton = findViewById(R.id.watchmovie)
//        movieLink = findViewById(R.id.movie_link)
//        moviedescription = findViewById(R.id.movie_description)
//
        // Get the movie details from the intent
        val title = intent.getStringExtra("title")
//        val backgroundUrl = intent.getStringExtra("backgroundUrl")
        val movieLink = intent.getStringExtra("movieLink")
//        val movieTrailer = intent.getStringExtra("movieTrailer")
//        val movieType = intent.getStringExtra("movieType")
//        val posterUrl = intent.getStringExtra("posterUrl")
//        val description = intent.getStringExtra("description")
//
//        // Display the movie title, description
        movietitle.text = title
//        moviedescription.text = description
//
//        // Load the background image and poster image using Glide
//        Glide.with(this)
//            .load(backgroundUrl)
//            .into(moviebackground)  // Set the background image
//
//        Glide.with(this)
//            .load(posterUrl)
//            .into(movieimage)  // Set the movie poster image

//         Button to watch the movie or movie trailer
        moviebutton.setOnClickListener {
            // Check if movieLink or movieTrailer is available
            if (movieLink != null) {
                val intent = Intent(this, movievideo::class.java)
                intent.putExtra("movieLink", movieLink)
                startActivity(intent)
            } else {
                Toast.makeText(this, "No movie link or trailer available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
