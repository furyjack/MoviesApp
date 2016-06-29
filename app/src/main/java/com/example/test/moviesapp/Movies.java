package com.example.test.moviesapp;

import java.util.ArrayList;

public class Movies {

    public static class movie
    {
        String movie_url;

        public movie(String movie_url) {
            this.movie_url = movie_url;
        }
    }

   public static ArrayList<movie> getMovies()
    {
        ArrayList<movie> mlist=new ArrayList<>(10);
        mlist.add(new movie("http://image.tmdb.org/t/p/w780//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg"));
        mlist.add(new movie("http://image.tmdb.org/t/p/w780///zSouWWrySXshPCT4t3UKCQGayyo.jpg"));
        mlist.add(new movie("http://image.tmdb.org/t/p/w780//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg"));
        mlist.add(new movie("http://image.tmdb.org/t/p/w780///zSouWWrySXshPCT4t3UKCQGayyo.jpg"));
        mlist.add(new movie("http://image.tmdb.org/t/p/w780//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg"));
        mlist.add(new movie("http://image.tmdb.org/t/p/w780///zSouWWrySXshPCT4t3UKCQGayyo.jpg"));
        mlist.add(new movie("http://image.tmdb.org/t/p/w780//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg"));
        mlist.add(new movie("http://image.tmdb.org/t/p/w780///zSouWWrySXshPCT4t3UKCQGayyo.jpg"));
        mlist.add(new movie("http://image.tmdb.org/t/p/w780//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg"));
        mlist.add(new movie("http://image.tmdb.org/t/p/w780///zSouWWrySXshPCT4t3UKCQGayyo.jpg"));

        return mlist;

    }



}
