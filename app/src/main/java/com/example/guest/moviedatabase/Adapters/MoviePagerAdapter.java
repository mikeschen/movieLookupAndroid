package com.example.guest.moviedatabase.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.guest.moviedatabase.models.Movies;
import com.example.guest.moviedatabase.ui.MovieDetailFragment;

import java.util.ArrayList;

/**
 * Created by Guest on 4/27/16.
 */
public class MoviePagerAdapter extends FragmentPagerAdapter{
    private ArrayList<Movies> mMovies;

    public MoviePagerAdapter(FragmentManager fm, ArrayList<Movies> movies) {
        super(fm);
        mMovies = movies;
    }

    @Override
    public Fragment getItem(int position) {
        return MovieDetailFragment.newInstance(mMovies.get(position));
    }

    @Override
    public int getCount() {
        return mMovies.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mMovies.get(position).getTitle();
    }
}
