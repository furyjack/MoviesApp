package com.example.test.moviesapp;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class Searchable extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);
        Intent intent = getIntent();

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            String[] arr = query.split(" ");
            ArrayList<String> keywords = new ArrayList<>(Arrays.asList(arr));
            String Title = "";
            for (int i = 0; i < keywords.size() - 1; i++) {
                Title += keywords.get(i) + "+";
            }
            Title += keywords.get(keywords.size() - 1);
            query = "http://www.omdbapi.com/?t=" + Title + "&y=&plot=Full&r=json";
            String jsonstr = "";
            try {

                jsonstr = new FetchMovieTask().execute(query).get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            JsonSearchClass.movieobject obj = new JsonSearchClass(jsonstr).get_movie();
            if (obj != null) {
                Intent i = new Intent(this, Detail_Movie_Activity.class);
                Bundle tags = new Bundle();
                tags.putString("name", obj.name);
                tags.putString("overview", obj.overview);
                tags.putString("picture_url", obj.poster_path);
                tags.putString("date", obj.release);
                tags.putString("level", obj.runtime);
                tags.putString("rating", obj.rating);
                i.putExtras(tags);
                startActivity(i);


            } else {
                Toast.makeText(Searchable.this, "No Media Found", Toast.LENGTH_SHORT).show();
                finish();
            }


        }

    }

    @Override
    protected void onStop() {
        super.onStop();
        finish();
    }
}
