package com.example.flixster1.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

//import com.bumptech.glide.Glide;
import com.bumptech.glide.Glide;
import com.example.flixster1.R;
import com.example.flixster1.model.Movie;

import java.util.List;

// as creating de ViewHolder within the class, come back to edit the public class
public class MovieAdaptor extends RecyclerView.Adapter<MovieAdaptor.ViewHolder> {

    Context context;
    List<Movie> movies;

    public MovieAdaptor(Context context, List<Movie> movies) {
        this.context = context;
        this.movies = movies;
    }

    // ViewHolder(onCreateViewHolder)
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new  ViewHolder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //get a movie at a position
        Movie movie = movies.get(position);
        //bind the movie from the data to the UI
        holder.bind(movie);

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView ivPoster;
        TextView tvDescription;
        TextView tvTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivPoster = itemView.findViewById(R.id.ivPoster);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvDescription = itemView.findViewById(R.id.tvDescription);
        }


        public void bind(Movie movie) {

            tvTitle.setText(movie.getTitle());
            tvDescription.setText(movie.getDescription());
            Glide.with(context).load(movie.getPosterPath()).into(ivPoster);
        }
    }
}


