package com.example.test.moviesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "haala";

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;


    void set_naviagtion() {
        String[] mPlanetTitles = {"item1", "item2", "item3", "item4"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_menu_white_48dp, R.string.app_name, R.string.app_name);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mPlanetTitles));

    }

    void setRecyclerView() {

        FetchMovieTask task=new FetchMovieTask();
        String jsonstr = null;
        try {
            jsonstr = (task.execute("http://api.themoviedb.org/3/movie/upcoming?api_key=a444d7a7a662a5a702515b3735ee4f49")).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Something went wrong,Please restart the app", Toast.LENGTH_SHORT).show();
        } catch (ExecutionException e) {
            e.printStackTrace();
            Toast.makeText(MainActivity.this, "Something went wrong,Please restart the app", Toast.LENGTH_SHORT).show();
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_movie);
        ArrayList<Movies.movie> movies = Movies.initialize_movie(jsonstr);
        MovieAdapter movieAdapter = new MovieAdapter(movies);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayout.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerView();


    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMoviePoster;

        public MovieViewHolder(View itemView) {
            super(itemView);
            ivMoviePoster = (ImageView) itemView.findViewById(R.id.iv_movieposter);
        }


    }


    public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
        ArrayList<Movies.movie> movieArrayList;

        public MovieAdapter(ArrayList<Movies.movie> movieArrayList) {
            this.movieArrayList = movieArrayList;
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = getLayoutInflater();
            View itemview = inflater.inflate(R.layout.movie_list_item, parent, false);
            MovieViewHolder holder = new MovieViewHolder(itemview);

            return holder;
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, final int position) {

            Movies.movie mobject = movieArrayList.get(position);
            Picasso.with(getApplicationContext()).load(mobject.movie_url).into(holder.ivMoviePoster);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent go_deatil = new Intent(getApplicationContext(), Detail_Movie_Activity.class);
                    Movies.movie obj = movieArrayList.get(position);
                    Bundle tags = new Bundle();
                    tags.putString("name", obj.name);
                    tags.putString("overview", obj.overview);
                    tags.putString("picture_url", obj.movie_url);
                    tags.putString("date", obj.release_date);
                    tags.putString("level", obj.level);
                    tags.putString("rating", obj.rating);

                    go_deatil.putExtras(tags);

                    startActivity(go_deatil);
                }
            });
        }

        @Override
        public int getItemCount() {
            return movieArrayList.size();
        }
    }


}
