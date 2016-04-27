package com.example.guest.moviedatabase.models;

/**
 * Created by Guest on 4/27/16.
 */
public class Movies {
    private String mTitle;
    private String mOverview;


    public Movies(String title, String overview) {
        this.mTitle = title;
        this.mOverview = overview;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getOverview() {
        return mOverview;
    }

}
