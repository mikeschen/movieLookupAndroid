package com.example.guest.moviedatabase.models;

/**
 * Created by Guest on 4/28/16.
 */
public class Actors {
    private String mActorName;
    private String mMovies;


    public Actors(String name, String movies) {
        this.mActorName = name;
        this.mMovies = movies;
    }

    public String getActorName() {
        return mActorName;
    }

    public String getMovies() {
        return mMovies;
    }
}
