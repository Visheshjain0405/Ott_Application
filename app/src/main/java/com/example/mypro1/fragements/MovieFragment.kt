package com.example.mypro1.fragements

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mypro1.Movie
import com.example.mypro1.R
import com.example.mypro1.adapter.MovieAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class MovieFragment : Fragment() {

    private lateinit var databaseReference: DatabaseReference
    private lateinit var movieList: MutableList<Movie>
    private lateinit var movieAdapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_movie, container, false)

        // Initialize the database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Movies")

        // Initialize the movie list and adapter
        movieList = mutableListOf()
        movieAdapter = MovieAdapter(requireContext(), movieList)

        // Find the RecyclerView from the inflated view
        val recyclerView: RecyclerView = view.findViewById(R.id.recycleview)
        val layoutManager = GridLayoutManager(requireContext(), 3)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = movieAdapter

        // Set up ValueEventListener to fetch data from Firebase
        databaseReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                movieList.clear()

                // Loop through each movie node in Firebase
                for (snapshot in dataSnapshot.children) {
                    // Retrieve movie details
                    val title = snapshot.child("title").getValue(String::class.java)
                    val backgroundUrl = snapshot.child("backgroundUrl").getValue(String::class.java)
                    val movieLink = snapshot.child("movieLink").getValue(String::class.java)
                    val movieTrailer = snapshot.child("movieTrailer").getValue(String::class.java)
                    val movieType = snapshot.child("movieType").getValue(String::class.java)
                    val posterUrl = snapshot.child("posterUrl").getValue(String::class.java)
                    val description = snapshot.child("description").getValue(String::class.java)
                    val date = snapshot.child("date").getValue(String::class.java)
                    val mobileBackgroundUrl = snapshot.child("mobileBackgroundUrl").getValue(String::class.java)
                    val slider = snapshot.child("slider").getValue(String::class.java)
                    val timestamp = snapshot.child("timestamp").getValue(Long::class.java)

                    // Check if all required fields are not null before adding to the list
                    if (title != null && backgroundUrl != null && movieLink != null && movieTrailer != null &&
                        movieType != null && posterUrl != null && description != null && date != null &&
                        mobileBackgroundUrl != null && slider != null && timestamp != null) {
                        val movie = Movie(
                            title,
                            backgroundUrl,
                            movieLink,
                            movieTrailer,
                            movieType,
                            posterUrl,
                            description,
                            date,
                            mobileBackgroundUrl,
                            slider,
                            timestamp
                        )
                        movieList.add(movie)
                    }
                }

                // Notify the adapter that the data has changed
                movieAdapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                // Handle errors
            }
        })

        return view
    }
}
