package com.example.guest.moviedatabase.models;

import org.parceler.Parcel;

/**
 * Created by Guest on 4/27/16.
 */

@Parcel
public class Movies {
    private String mTitle;
    private String mOverview;
    private String mImageUrl;
    private String mDate;
    private Double mRating;
    private int mId;

    public Movies(String title, String overview, String imageUrl, String date, Double rating, int id) {
        this.mTitle = title;
        this.mOverview = overview;
        this.mImageUrl = "http://image.tmdb.org/t/p/w500" + imageUrl;
        this.mDate = date;
        this.mRating = rating;
        this.mId = id;
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

    public String getDate() { return mDate; }

    public Double getRating() { return mRating; }

    public int getId() { return mId; }

    public Movies() {
    }
}
