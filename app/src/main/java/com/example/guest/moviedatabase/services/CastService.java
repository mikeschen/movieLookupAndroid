package com.example.guest.moviedatabase.services;

import android.util.Log;

import com.example.guest.moviedatabase.Constants;
import com.example.guest.moviedatabase.models.Cast;

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
 * Created by Guest on 4/28/16.
 */
public class CastService {

    public static void findCast(String id, Callback callback) {
        String CONSUMER_KEY = Constants.MOVIE_CONSUMER_KEY;


        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.MOVIE_CAST_URL).newBuilder();
        urlBuilder.addPathSegment(id + "");
        urlBuilder.addPathSegment("credits");
        urlBuilder.addQueryParameter("api_key", CONSUMER_KEY);
        String url = urlBuilder.build().toString();
        Log.d("cast string", url);
        Request request= new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);

    }

    public ArrayList<Cast> processResults(Response response) {
        ArrayList<Cast> casts = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject movieCastJSON = new JSONObject(jsonData);
                JSONArray creditsJSON = movieCastJSON.getJSONArray("cast");
                for (int i = 0; i < creditsJSON.length(); i++) {
                    JSONObject castJSON = creditsJSON.getJSONObject(i);
                    String name = castJSON.getString("name");
                    String character = castJSON.getString("character");
                Cast cast = new Cast(name, character);
                casts.add(cast);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return casts;
    }
}
