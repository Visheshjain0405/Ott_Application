package com.example.mypro1.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mypro1.Movie
import com.example.mypro1.R
import com.example.mypro1.moviedisplay

class MovieAdapter(private val context: Context, private val movies: List<Movie>) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById(R.id.titleTextView)
        val posterImageView: ImageView = itemView.findViewById(R.id.imageViewPoster)
//        val descriptionTextView: TextView = itemView.findViewById(R.id.movie)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycle_item, parent, false)
        return MovieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]

        holder.titleTextView.text = movie.title

        holder.posterImageView.setOnClickListener{
            val moviedisplayintent= Intent(context,moviedisplay::class.java)
            moviedisplayintent.putExtra("title", movie.title)
            moviedisplayintent.putExtra("description", movie.description)
            moviedisplayintent.putExtra("movieLink",movie.movieLink)
            context.startActivity((moviedisplayintent))
        }
//        holder.descriptionTextView.text = movie.description
        Glide.with(context)
            .load(movie.posterUrl)
            .into(holder.posterImageView)
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
