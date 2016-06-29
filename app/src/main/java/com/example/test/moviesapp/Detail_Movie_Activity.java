package com.example.test.moviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detail_Movie_Activity extends AppCompatActivity {

    TextView name,overview,rating,level,release;
    ImageView poster;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);
        getSupportActionBar().hide();
        name= (TextView) findViewById(R.id.tv_name);
        overview= (TextView) findViewById(R.id.tv_overview);
        rating= (TextView) findViewById(R.id.rating);
        level= (TextView) findViewById(R.id.level);
        release= (TextView) findViewById(R.id.release_date);
        poster= (ImageView) findViewById(R.id.iv_detail_poster);

        Bundle extra=getIntent().getExtras();
        String Name=extra.getString("name");
        String Ov=extra.getString("overview");
        String R=extra.getString("date");
        String lev=extra.getString("level");
        String ratin=extra.getString("rating");
        String uri=extra.getString("picture_url");

        name.setText(Name);
        overview.setText(Ov);
        rating.setText(ratin);
        level.setText(lev);
        release.setText(R);
        Picasso.with(getApplicationContext()).load(uri).into(poster);




    }
}
