package com.example.test.moviesapp;

import java.util.ArrayList;

public class Movies {

    public static ArrayList<movie> mlist;


    public static class movie
    {
        String movie_url;
        String overview;
        String rating;
        String level;
        String release_date;
        String name;

        public movie(String movie_url, String overview, String rating, String level, String release_date,String name) {
            this.movie_url = movie_url;
            this.overview = overview;
            this.rating = rating;
            this.level = level;
            this.release_date = release_date;
            this.name=name;
        }
    }


   public static  ArrayList<movie> initialize_movie(String jsonstr)
   {
       ArrayList<String> movie_url=JsonTest.get_movies(jsonstr);
       ArrayList<String> overview=JsonTest.get_overview(jsonstr);
       ArrayList<String> rating =JsonTest.get_rating(jsonstr);
       ArrayList<String> level=JsonTest.get_level(jsonstr);
       ArrayList<String> release_date=JsonTest.get_release(jsonstr);
       ArrayList<String> name=JsonTest.get_name(jsonstr);

       mlist=new ArrayList<>();
       for(int i=0;i<movie_url.size();i++) {


           mlist.add(new movie(movie_url.get(i),overview.get(i),rating.get(i),level.get(i),release_date.get(i),name.get(i)));

       }
       return mlist;

   }

   /*public static ArrayList<movie> getMovies()
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
*/


}
