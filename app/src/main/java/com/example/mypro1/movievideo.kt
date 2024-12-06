package com.example.mypro1

import android.net.Uri
import android.os.Bundle
import android.widget.MediaController
import android.widget.Toast
import android.widget.VideoView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.ui.PlayerView

class movievideo : AppCompatActivity() {

    private lateinit var videoView: VideoView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movievideo)

        // Enable edge to edge display if you have implemented this function
        val movieLink = intent.getStringExtra("movieLink")
        Toast.makeText(this, movieLink, Toast.LENGTH_SHORT).show()
        if (movieLink != null) {
            playVideo(movieLink)
        }else{
            Toast.makeText(this, "movie is not playing", Toast.LENGTH_SHORT).show()
        }
    }

    private fun playVideo(url: String) {
        val mediaController = MediaController(this)
        videoView.setMediaController(mediaController)
        videoView.setVideoPath(url)
        videoView.requestFocus()
        videoView.start()
    }
}
