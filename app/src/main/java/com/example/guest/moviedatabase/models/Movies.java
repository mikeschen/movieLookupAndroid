package com.example.guest.moviedatabase.models;

/**
 * Created by Guest on 4/27/16.
 */
public class Movies {
    private String mTitle;
    private String mOverview;
    private String mImageUrl;


    public Movies(String title, String overview, String imageUrl) {
        this.mTitle = title;
        this.mOverview = overview;
        this.mImageUrl = "http://image.tmdb.org/t/p/w500" + imageUrl;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getOverview() {
        return mOverview;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

}
