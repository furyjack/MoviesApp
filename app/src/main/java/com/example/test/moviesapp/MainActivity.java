package com.example.test.moviesapp;

import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       RecyclerView recyclerView=(RecyclerView)findViewById(R.id.rv_movie);
        ArrayList<Movies.movie> movies=Movies.getMovies();
        MovieAdapter movieAdapter=new MovieAdapter(movies);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);


       // Picasso.with(getApplicationContext()).load("http://image.tmdb.org/t/p/w780//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg").resize(300,300).into(ivTest);

    }

    public class MovieViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivMoviePoster;
        public MovieViewHolder(View itemView) {
            super(itemView);
            ivMoviePoster=(ImageView)itemView.findViewById(R.id.iv_movieposter);
        }


    }


    public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder>
    {
        ArrayList<Movies.movie> movieArrayList;

        public MovieAdapter(ArrayList<Movies.movie> movieArrayList) {
            this.movieArrayList = movieArrayList;
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater=getLayoutInflater();
            View itemview=inflater.inflate(R.layout.movie_list_item,parent,false);
            MovieViewHolder holder=new MovieViewHolder(itemview);

            return holder;
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {

            Movies.movie mobject=movieArrayList.get(position);
            Picasso.with(getApplicationContext()).load(mobject.movie_url).into(holder.ivMoviePoster);

        }

        @Override
        public int getItemCount() {
            return movieArrayList.size();
        }
    }









}
