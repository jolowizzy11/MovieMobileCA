package com.example.moviemobile;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        // Obtain and fill data for the Movie class
        Movie[] movies = new Movie[]{
                new Movie("SUPER MARIO BROS. MOVIE",
                        "https://images.mymovies.net/images/film/cin/350x522/fid21548.jpg",
                        "PG",
                        "A plumber named Mario travels through an underground labyrinth with his brother, Luigi, trying to save a captured princess.",
                        new String[]{"Chris Pratt", "Anya Taylor-Joyz", "Charlie Day", "Jack BlacK", "Seth Rogen"},
                        (int) (Math.random() * 16),
                        92),

                new Movie("SUZUME (SUBTITLED)",
                        "https://www.myvue.com/-/media/ac12cc48f2a64278ae7151ab0c861f90.png?w=200",
                        "PG",
                        "A charming thief and a band of unlikely adventurers undertake an epic heist to retrieve a lost relic, but things go dangerously awry when they run afoul of the wrong people.",
                            new String[]{"Chris Pine", "Michelle Rodriguez", "Justice Smith", "Rege-Jean Page", "Sophia Lillis", "Chloe Coleman","Daisy Head","Hugh Grant"},
                        (int) (Math.random() * 16),
                        134),

                new Movie("PATHAAN",
                        "https://images.mymovies.net/images/film/cin/350x522/fid22177.jpg",
                        "PG",
                        "Make. Some. Noise! 'Pathaan' is here! The high-octane spy thriller 'Pathaan' starring Shah Rukh Khan, Deepika Padukone and John Abraham, directed by Siddharth Anand is set to release on January 25, 2023.",
                        new String[]{"Deepika Padukone", "Shah Rukh Khan", "John Abraham"},
                        (int) (Math.random() * 16),
                        180),



                new Movie("SHAZAM! FURY OF THE GODS",
                        "https://www.myvue.com/-/media/5ed39a4149e3489d83f82d8ae8976c06.png?w=200",
                        "12A",
                        "When the Daughters of Atlas, a vengeful trio of ancient gods, arrive on Earth in search of the magic stolen from them long ago, Billy - aka Shazam - and his family are thrust into a battle for their superpowers, their lives, and the fate of their world.",
                        new String[]{"Zachary Levi", "Helen Mirren", "Adam Brody", "Lucy Liu", "Grace Caroline Currey"},
                        (int) (Math.random() * 2),
                        120)
        };

        // Display the movies in a RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        MovieAdapter adapter = new MovieAdapter(movies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
