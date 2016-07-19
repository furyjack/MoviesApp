package com.example.test.moviesapp;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class DisplaySection extends Fragment {

    TextView title;
    OnCreateViewCalledListener ocvcl;
    public static final String TAG="logs";

    private String type;
    private String query;
    private Context context;

    public static DisplaySection newInstance(String t, String q) {

        Bundle args = new Bundle();
        args.putString("title", t);
        args.putString("query", q);

        DisplaySection fragment = new DisplaySection();
        fragment.setArguments(args);
        return fragment;
    }

    void setRecyclerView(View layout) {
        Log.d(TAG, "setRecyclerView: ");
        FetchMovieTask task = new FetchMovieTask();
        String jsonstr = null;
        try {
            jsonstr = (task.execute(query)).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            Toast.makeText(context, "Something went wrong,Please restart the app", Toast.LENGTH_SHORT).show();
        } catch (ExecutionException e) {
            e.printStackTrace();
            Toast.makeText(context, "Something went wrong,Please restart the app", Toast.LENGTH_SHORT).show();
        }

        RecyclerView recyclerView = (RecyclerView) layout.findViewById(R.id.f_rv_display);
        ArrayList<Movies.movie> movies = Movies.initialize_movie(jsonstr);
        MovieAdapter movieAdapter = new MovieAdapter(movies);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);


    }

    public void setOnCreateViewCalledListener(OnCreateViewCalledListener listener) {
        this.ocvcl = listener;
    }

    public void setup(View layout) {

        title = (TextView) layout.findViewById(R.id.f_tv_title);


        Bundle args = getArguments();
        type = args.getString("title");
        query = args.getString("query");

        context = (getActivity()).getApplicationContext();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_display_section, container, false);

        setup(layout);
        setRecyclerView(layout);
        title.setText(type);


        return layout;
    }

    public interface OnCreateViewCalledListener {
        void onCreateViewCalled();

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

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemview = inflater.inflate(R.layout.movie_list_item, parent, false);
            MovieViewHolder holder = new MovieViewHolder(itemview);

            return holder;
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, final int position) {

            Movies.movie mobject = movieArrayList.get(position);
            Picasso.with(context).load(mobject.movie_url).into(holder.ivMoviePoster);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent go_deatil = new Intent(context, Detail_Movie_Activity.class);
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
