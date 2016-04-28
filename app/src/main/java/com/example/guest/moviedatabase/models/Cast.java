package com.example.guest.moviedatabase.models;

/**
 * Created by Guest on 4/28/16.
 */
public class Cast {
    private String mName;
    private String mCharacter;
    private String mImage;

    public Cast(String name, String character, String image) {
        this.mName = name;
        this.mCharacter = character;
        this.mImage = "http://image.tmdb.org/t/p/w185" + image;
    }

    public String getName() {
        return mName;
    }

    public String getCharacter() {
        return mCharacter;
    }

    public String getImage() {
        return mImage;
    }
}
