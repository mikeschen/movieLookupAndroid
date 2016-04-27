package com.example.guest.moviedatabase.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.moviedatabase.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.searchButton) Button mSearchButton;
    @Bind(R.id.titleEditText) EditText mTitleEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSearchButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String title = mTitleEditText.getText().toString();
                Log.d("title", title);
                Intent intent = new Intent(MainActivity.this, ResultListActivity.class);
                intent.putExtra("title", title);
                startActivity(intent);
            }
        });
    }
}
