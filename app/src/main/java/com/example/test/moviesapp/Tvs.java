package com.example.test.moviesapp;


import java.util.ArrayList;

public class Tvs {

    public static ArrayList<tv> mlist;

    public static ArrayList<tv> initialize_tv(String jsonstr) {
        ArrayList<String> poster_url = JsonTest.get_movies(jsonstr);
        ArrayList<String> overview = JsonTest.get_overview(jsonstr);
        ArrayList<String> rating = JsonTest.get_rating(jsonstr);
        ArrayList<String> first_on_air = JsonTest.get_release(jsonstr, "t");
        ArrayList<String> name = JsonTest.get_name(jsonstr, "t");

        mlist = new ArrayList<>();
        for (int i = 0; i < poster_url.size(); i++) {


            mlist.add(new tv(poster_url.get(i), rating.get(i), overview.get(i), first_on_air.get(i), name.get(i)));

        }
        return mlist;

    }

    public static class tv {
        String poster_url;
        String overview;
        String rating;
        String first_on_air;
        String name;


        public tv(String poster_url, String rating, String overview, String first_on_air, String name) {
            this.poster_url = poster_url;
            this.rating = rating;
            this.overview = overview;
            this.first_on_air = first_on_air;
            this.name = name;
        }
    }


}
