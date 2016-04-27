package com.example.guest.moviedatabase.ui;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.moviedatabase.R;
import com.example.guest.moviedatabase.models.Movies;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MovieDetailFragment extends Fragment {
    private static final int MAX_WIDTH = 500;
    private static final int MAX_HEIGHT = 400;

    @Bind(R.id.movieImageView) ImageView mMovieImageView;
    @Bind(R.id.movieTitleTextView) TextView mMovieTitleTextView;
    @Bind(R.id.overviewTextView) TextView mOverviewTextView;

    private Movies mMovie;

    public static MovieDetailFragment newInstance(Movies movie) {
        MovieDetailFragment movieDetailFragment = new MovieDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("movie", Parcels.wrap(movie));
        movieDetailFragment.setArguments(args);
        return movieDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mMovie = Parcels.unwrap(getArguments().getParcelable("movie"));
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_movie_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext())
                .load(mMovie.getImageUrl())
                .resize(MAX_WIDTH, MAX_HEIGHT)
//                .centerCrop()
                .into(mMovieImageView);
        mMovieTitleTextView.setText(mMovie.getTitle());
        mOverviewTextView.setText(mMovie.getOverview());
        return view;
    }

}
