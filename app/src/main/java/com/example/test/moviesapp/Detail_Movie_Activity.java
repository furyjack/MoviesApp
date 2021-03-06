package com.example.test.moviesapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class Detail_Movie_Activity extends AppCompatActivity {

    TextView name, overview, rating, level, release;
    ImageView poster;

    void init_vars() {
        name = (TextView) findViewById(R.id.tv_name);
        overview = (TextView) findViewById(R.id.tv_overview);
        rating = (TextView) findViewById(R.id.rating);
        level = (TextView) findViewById(R.id.level);
        release = (TextView) findViewById(R.id.release_date);
        poster = (ImageView) findViewById(R.id.iv_detail_poster);


    }

    void set_vars() {

        Bundle extra = getIntent().getExtras();
        String Name = extra.getString("name");
        String Ov = extra.getString("overview");
        String R = extra.getString("date");
        String lev = extra.getString("level");
        String ratin = extra.getString("rating") + "/10.0";
        String uri = extra.getString("picture_url");


        name.setText(Name);
        overview.setText(Ov);
        rating.setText(ratin);
        level.setText(lev);
        release.setText(R);
        Picasso.with(getApplicationContext()).load(uri).into(poster);


    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        init_vars();
        set_vars();


    }
}
