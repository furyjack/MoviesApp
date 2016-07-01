package com.example.test.moviesapp;


import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

public class DisplaySectionTv extends Fragment{

    TextView title;
    OnCreateViewCalledListener ocvcl;

    private String type;
    private String query;
    private Context context;


    void setRecyclerView(View layout) {

        FetchMovieTask task=new FetchMovieTask();
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
        ArrayList<Tvs.tv> tvs = Tvs.initialize_tv(jsonstr);
        TvAdapter tvAdapter = new TvAdapter(tvs);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(context, LinearLayout.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(tvAdapter);
        tvAdapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);


    }

    public void setOnCreateViewCalledListener(OnCreateViewCalledListener listener)
    {
        this.ocvcl=listener;
    }


    public static DisplaySectionTv newInstance(String t,String q) {

        Bundle args = new Bundle();
        args.putString("title",t);
        args.putString("query",q);

        DisplaySectionTv fragment = new DisplaySectionTv();
        fragment.setArguments(args);
        return fragment;
    }

    public void setup(View layout)
    {

        title= (TextView) layout.findViewById(R.id.f_tv_title);


        Bundle args=getArguments();
        type=args.getString("title");
        query=args.getString("query");

        context=(getActivity()).getApplicationContext();



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout=inflater.inflate(R.layout.fragment_display_section, container, false);

        setup(layout);
        setRecyclerView(layout);
        title.setText(type);





        return layout;
    }

    public interface OnCreateViewCalledListener
    {
        void onCreateViewCalled();

    }


    public class TvViewHolder extends RecyclerView.ViewHolder {
        ImageView ivMoviePoster;

        public TvViewHolder(View itemView) {
            super(itemView);
            ivMoviePoster = (ImageView) itemView.findViewById(R.id.iv_movieposter);
        }


    }


    public class TvAdapter extends RecyclerView.Adapter<TvViewHolder> {
        ArrayList<Tvs.tv> tvArrayList;

        public TvAdapter(ArrayList<Tvs.tv> tvArrayList) {
            this.tvArrayList = tvArrayList;
        }

        @Override
        public TvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            View itemview = inflater.inflate(R.layout.movie_list_item, parent, false);
            TvViewHolder holder = new TvViewHolder(itemview);

            return holder;
        }

        @Override
        public void onBindViewHolder(TvViewHolder holder, final int position) {

            Tvs.tv mobject = tvArrayList.get(position);
            Picasso.with(context).load(mobject.poster_url).into(holder.ivMoviePoster);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent go_deatil = new Intent(context, Detail_Movie_Activity.class);
                    Tvs.tv obj = tvArrayList.get(position);
                    Bundle tags = new Bundle();
                    tags.putString("name", obj.name);
                    tags.putString("overview", obj.overview);
                    tags.putString("picture_url", obj.poster_url);
                    tags.putString("date", obj.first_on_air);
                    tags.putString("rating", obj.rating);
                    tags.putString("level","U/A");

                    go_deatil.putExtras(tags);

                    startActivity(go_deatil);
                }
            });
        }

        @Override
        public int getItemCount() {
            return tvArrayList.size();
        }
    }















}
