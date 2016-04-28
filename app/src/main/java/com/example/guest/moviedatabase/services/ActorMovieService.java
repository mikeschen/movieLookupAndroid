package com.example.guest.moviedatabase.services;

import android.util.Log;

import com.example.guest.moviedatabase.Constants;
import com.example.guest.moviedatabase.models.Actors;

import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;

/**
 * Created by Guest on 4/28/16.
 */
public class ActorMovieService {
    public static void findActorMovies(String id, Callback callback) {
        String CONSUMER_KEY = Constants.MOVIE_CONSUMER_KEY;

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_ACTOR_URL).newBuilder();
        urlBuilder.addPathSegment(id + "");
        urlBuilder.addPathSegment("movie_credits");
        urlBuilder.addQueryParameter("api_key", CONSUMER_KEY);
        String url = urlBuilder.build().toString();
        Log.d("actor string", url);
        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Actors> processResults(Response response) {
        ArrayList<Actors> actors = new ArrayList<>();
    return actors;
    }

}
