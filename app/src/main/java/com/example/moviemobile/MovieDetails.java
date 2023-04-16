package com.example.moviemobile;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;


public class MovieDetails extends AppCompatActivity {

    private int seatsRemaining;
    private int seatsSelected;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        // Get movie object from intent
        Movie movie = getIntent().getParcelableExtra("movie");

        // Initialize seatsRemaining and seatsSelected values
        seatsRemaining = movie.getSeatsRemaining();
        seatsSelected = 0;

        // Set up views
        ImageView movieImage = findViewById(R.id.movie_image);
        TextView movieTitle = findViewById(R.id.movie_name);
        TextView movieCertification = findViewById(R.id.movie_certification);
        TextView movieDescription = findViewById(R.id.movie_description);
        TextView movieStarring = findViewById(R.id.movie_starring);
        TextView movieRunningTime = findViewById(R.id.movie_running_time);
        TextView movieSeatsRemaining = findViewById(R.id.movie_seats_remaining);
        ImageView minusButton = findViewById(R.id.minus_button);
        ImageView plusButton = findViewById(R.id.plus_button);

        // Load movie data into views
        Glide.with(movieImage.getContext())
                .load(movie.getImage())
                .into(movieImage);
        movieTitle.setText(movie.getName());
        movieCertification.setText(movie.getCertification());
        movieDescription.setText(movie.getDescription());
        movieStarring.setText("Starring: " + TextUtils.join(", ", movie.getStarring()));
        movieRunningTime.setText("Running time: " + movie.getRunningTime() + " minutes");
        movieSeatsRemaining.setText("Seats remaining: " + seatsRemaining);

        // Set click listener for minus button
        minusButton.setOnClickListener(v -> {
            if (seatsSelected > 0) {
                seatsSelected--;
                seatsRemaining++;
                updateSeatsText();
                updateSeatsRemainingText();
            }
        });

        // Set click listener for plus button
        plusButton.setOnClickListener(v -> {
            if (seatsRemaining > 0) {
                seatsSelected++;
                seatsRemaining--;
                updateSeatsText();
                updateSeatsRemainingText();
            }
        });

        // Update seats text
        updateSeatsText();
        updateSeatsRemainingText();
    }

    @Override
    public void onBackPressed() {
        Intent resultIntent = new Intent();
        resultIntent.putExtra("selectedSeats", seatsSelected);
        setResult(Activity.RESULT_OK, resultIntent);
        super.onBackPressed();
    }

    private void updateSeatsText() {
        TextView seatsSelectedText = findViewById(R.id.seats_selected_text);
        seatsSelectedText.setText(String.valueOf(seatsSelected));
    }

    private void updateSeatsRemainingText() {
        TextView seatsRemainingText = findViewById(R.id.seats_remaining_text);
        seatsRemainingText.setText(String.valueOf(seatsRemaining));
        ImageView minusButton = findViewById(R.id.minus_button);
        ImageView plusButton = findViewById(R.id.plus_button);
        minusButton.setEnabled(seatsSelected > 0);
        plusButton.setEnabled(seatsRemaining > 0);
    }
}
