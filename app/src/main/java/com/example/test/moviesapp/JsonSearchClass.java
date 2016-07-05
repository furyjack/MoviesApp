package com.example.test.moviesapp;


import org.json.JSONException;
import org.json.JSONObject;

public class JsonSearchClass {
    private static String jsonstr;


    public static class movieobject
    {
        String name;
        String overview;
        String poster_path;
        String release;
        public movieobject(String name, String overview, String poster_path,String release) {
            this.name = name;
            this.overview = overview;
            this.poster_path = poster_path;
            this.release=release;
        }

    }

    public JsonSearchClass(String jsonstr) {
        this.jsonstr = jsonstr;
    }



   static movieobject get_movie()
   {

       movieobject mobject=null;
       JSONObject root= null;
       try {
           root = new JSONObject(jsonstr);

           String name = root.getString("Title");
           String overview = root.getString("Plot");
           String poster_path = root.getString("Poster");
           String release = root.getString("Released");

            mobject = new movieobject(name, overview, poster_path, release);
       }
       catch (JSONException e) {
           e.printStackTrace();
       }
       return  mobject;

   }




}

