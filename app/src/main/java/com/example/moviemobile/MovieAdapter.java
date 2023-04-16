package com.example.moviemobile;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private final Movie[] movies;

    public MovieAdapter(Movie[] movies) {
        this.movies = movies;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final ImageView movieImage;
        private final TextView movieTitle;
        private final TextView movieCertification;
        private final TextView movieDescription;
        private final TextView movieStarring;
        private final TextView movieRunningTime;
        private final TextView movieSeatsRemaining;
        private final TextView movieFillingFast;

        public ViewHolder(View itemView) {
            super(itemView);

            movieImage = itemView.findViewById(R.id.movie_image);
            movieTitle = itemView.findViewById(R.id.movie_title);
            movieCertification = itemView.findViewById(R.id.movie_certification);
            movieDescription = itemView.findViewById(R.id.movie_description);
            movieStarring = itemView.findViewById(R.id.movie_starring);
            movieRunningTime = itemView.findViewById(R.id.movie_running_time);
            movieSeatsRemaining = itemView.findViewById(R.id.movie_seats_remaining);
            movieFillingFast = itemView.findViewById(R.id.movie_filling_fast);


        }

        @SuppressLint("SetTextI18n")
        public void bind(Movie movie) {
            Glide.with(movieImage.getContext())
                    .load(movie.getImage())
                    .into(movieImage);

            movieTitle.setText(movie.getName());
            movieCertification.setText(movie.getCertification());
            movieDescription.setText(movie.getDescription());
            movieStarring.setText("Starring: " + TextUtils.join(", ", movie.getStarring()));
            movieRunningTime.setText("Running time: " + movie.getRunningTime() + " minutes");
            movieSeatsRemaining.setText("Seats remaining: " + movie.getSeatsRemaining());

            if (movie.getSeatsRemaining() < 3) {
                movieFillingFast.setVisibility(View.VISIBLE);
                movieFillingFast.setText("Filling Fast");
            } else {
                movieFillingFast.setVisibility(View.GONE);
            }

            // Set click listener to open MovieActivity
            itemView.setOnClickListener(view -> {
                Intent intent = new Intent(view.getContext(), MovieDetails.class);
                intent.putExtra("movie", movie); // Pass the Movie object directly
                view.getContext().startActivity(intent);
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_items, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(movies[position]);
    }

    @Override
    public int getItemCount() {
        return movies.length;
    }
}
