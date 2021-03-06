package com.example.flixster1.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Movie {
    String posterpath;
    String title;
    String description;

    public Movie(JSONObject jsonObject) throws JSONException {
        posterpath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        description = jsonObject.getString("overview");
    }
    public static List<Movie> fromJsonArray(JSONArray moviejsonarray) throws JSONException {
        List<Movie> movies = new ArrayList<>();
        for (int i=0; i < moviejsonarray.length(); i++){
            movies.add(new Movie(moviejsonarray.getJSONObject(i)));
        }
        return movies;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342%s", posterpath);
    }

    public String getTitle() {
        return title;
    }

    public String getDescription(){
        return description;
    }
}
