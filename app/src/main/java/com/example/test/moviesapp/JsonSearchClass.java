package com.example.test.moviesapp;


import org.json.JSONException;
import org.json.JSONObject;

public class JsonSearchClass {
    private String jsonstr;


    public JsonSearchClass(String jsonstr) {
        this.jsonstr = jsonstr;
    }

    movieobject get_movie() {
        if (jsonstr.equals(""))
            return null;

        movieobject mobject = null;
        JSONObject root = null;
        try {
            root = new JSONObject(jsonstr);

            String name = root.getString("Title");
            String overview = root.getString("Plot");
            String poster_path = root.getString("Poster");
            String release = root.getString("Released");
            String rating = root.getString("imdbRating");
            String runtime = root.getString("Runtime");
            runtime = runtime.split(" ")[0] + "m";

            mobject = new movieobject(name, overview, poster_path, release, rating, runtime);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return mobject;

    }

    public static class movieobject {
        String name;
        String overview;
        String poster_path;
        String release;
        String rating;
        String runtime;

        public movieobject(String name, String overview, String poster_path, String release, String rating, String runtime) {
            this.name = name;
            this.overview = overview;
            this.poster_path = poster_path;
            this.release = release;
            this.rating = rating;
            this.runtime = runtime;
        }

    }


}

