package com.example.guest.moviedatabase.ui;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guest.moviedatabase.R;
import com.example.guest.moviedatabase.models.Actors;
import com.example.guest.moviedatabase.services.ActorMovieService;


import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ActorDetailActivity extends AppCompatActivity {
    public ArrayList<Actors> mActors = new ArrayList<>();
    @Bind(R.id.listView) ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actor_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        getActors(id);
    }

    private void getActors(String id) {
        final ActorMovieService actorService = new ActorMovieService();

        ActorMovieService.findActorMovies(id, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response)  {
                mActors = actorService.processResults(response);



                ActorDetailActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String[] actorNames = new String[mActors.size()];

                        for(int i = 0; i < actorNames.length; i++) {
                            actorNames[i] = mActors.get(i).getActorName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(ActorDetailActivity.this,
                                android.R.layout.simple_list_item_1, actorNames);
                        mListView.setAdapter(adapter);
                    }
                });
            }
        });
    }
}
