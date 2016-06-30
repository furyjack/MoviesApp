package com.example.test.moviesapp;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonTest {

    static ArrayList<String> get_movies(String jsonstr)
    {

     ArrayList<String>movielist=new ArrayList<>(5);

        try {
            JSONObject root=new JSONObject(jsonstr);
            JSONArray jsonArray=root.getJSONArray("results");

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                String path="http://image.tmdb.org/t/p/w185/"+obj.getString("poster_path");
                movielist.add(path);


            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

     return movielist;
    }

    static ArrayList<String> get_overview(String jsonstr)
    {

        ArrayList<String>movielist=new ArrayList<>(5);

        try {
            JSONObject root=new JSONObject(jsonstr);
            JSONArray jsonArray=root.getJSONArray("results");

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                String overview=obj.getString("overview");
                movielist.add(overview);


            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movielist;
    }

    static ArrayList<String> get_rating(String jsonstr)
    {

        ArrayList<String>movielist=new ArrayList<>(5);

        try {
            JSONObject root=new JSONObject(jsonstr);
            JSONArray jsonArray=root.getJSONArray("results");

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                String rating=obj.getString("vote_average");
                movielist.add(rating);


            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movielist;
    }


    static ArrayList<String> get_level(String jsonstr)
    {

        ArrayList<String>movielist=new ArrayList<>(5);

        try {
            JSONObject root=new JSONObject(jsonstr);
            JSONArray jsonArray=root.getJSONArray("results");

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                Boolean adult=obj.getBoolean("adult");
                if(adult)
                movielist.add("A");
                else
                    movielist.add("U/A");


            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movielist;
    }


    static ArrayList<String> get_release(String jsonstr)
    {

        ArrayList<String>movielist=new ArrayList<>(5);

        try {
            JSONObject root=new JSONObject(jsonstr);
            JSONArray jsonArray=root.getJSONArray("results");

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                String overview=obj.getString("release_date");
                movielist.add(overview);


            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movielist;
    }

    static ArrayList<String> get_name(String jsonstr)
    {

        ArrayList<String>movielist=new ArrayList<>(5);

        try {
            JSONObject root=new JSONObject(jsonstr);
            JSONArray jsonArray=root.getJSONArray("results");

            for(int i=0;i<jsonArray.length();i++)
            {
                JSONObject obj=jsonArray.getJSONObject(i);
                String overview=obj.getString("title");
                movielist.add(overview);


            }



        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movielist;
    }

}
