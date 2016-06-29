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




}
