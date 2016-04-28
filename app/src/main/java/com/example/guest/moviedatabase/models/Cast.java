package com.example.guest.moviedatabase.models;

/**
 * Created by Guest on 4/28/16.
 */
public class Cast {
    private String mName;
    private String mCharacter;

    public Cast(String name, String character) {
        this.mName = name;
        this.mCharacter = character;
    }

    public String getName() {
        return mName;
    }

    public String getCharacter() {
        return mCharacter;
    }
}
