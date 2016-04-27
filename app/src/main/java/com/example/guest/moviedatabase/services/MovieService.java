package com.example.guest.moviedatabase.services;

import android.util.Log;

import com.example.guest.moviedatabase.Constants;
import com.example.guest.moviedatabase.models.Movies;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 4/27/16.
 */
public class MovieService {
    public static void findMovies(String title, Callback callback) {
        String CONSUMER_KEY = Constants.MOVIE_CONSUMER_KEY;

        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter("api_key", CONSUMER_KEY);
        urlBuilder.addQueryParameter(Constants.MOVIE_TITLE_QUERY_PARAMETER, title);

        String url = urlBuilder.build().toString();
        Log.d("urlName", url);
        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Movies> processResults(Response response) {
        ArrayList<Movies> movies = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject movieJSON = new JSONObject(jsonData);
                JSONArray resultsJSON = movieJSON.getJSONArray("results");
                for (int i = 0; i < resultsJSON.length(); i++) {
                    JSONObject flicksJSON = resultsJSON.getJSONObject(i);
                    String title = flicksJSON.getString("original_title");
                    String overview = flicksJSON.getString("overview");
                    String imageUrl = flicksJSON.getString("poster_path");
                    int id = flicksJSON.getInt("id");
                    Log.d("Id of Movie", id + "");
                    Movies movie = new Movies(title,overview, imageUrl);
                    movies.add(movie);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return movies;
    }

}
