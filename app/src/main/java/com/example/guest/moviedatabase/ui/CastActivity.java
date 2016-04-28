package com.example.guest.moviedatabase.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.guest.moviedatabase.R;
import com.example.guest.moviedatabase.models.Cast;
import com.example.guest.moviedatabase.services.CastService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class CastActivity extends AppCompatActivity {
    public ArrayList<Cast> mCasts = new ArrayList<>();
    @Bind(R.id.castListView) ListView mCastListView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cast);
            ButterKnife.bind(this);

            Intent intent = getIntent();
            String id = intent.getStringExtra("id");
            getCast(id);
        }

        private void getCast(String id) {
            final CastService castService = new CastService();

            CastService.findCast(id, new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    e.printStackTrace();
                }

                @Override
                public void onResponse(Call call, Response response)  {
                    mCasts = castService.processResults(response);

                    CastActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            String[] castNames = new String[mCasts.size()];
                            for(int i = 0; i < castNames.length; i++) {
                                castNames[i] = mCasts.get(i).getName();
                                Log.d("Hello", castNames[i]);
                            }
                            ArrayAdapter adapter = new ArrayAdapter(CastActivity.this,
                                    android.R.layout.simple_list_item_1, castNames);
                            mCastListView.setAdapter(adapter);

                        }
                    });
                }
            });
        }
}
