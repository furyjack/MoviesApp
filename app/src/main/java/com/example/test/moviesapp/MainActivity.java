package com.example.test.moviesapp;

import android.content.Intent;
import android.graphics.Movie;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity  {


    public static final String TAG="haala";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String jsonstr="{\"page\":1,\"results\":[{\"poster_path\":\"\\/zSouWWrySXshPCT4t3UKCQGayyo.jpg\",\"adult\":false,\"overview\":\"Since the dawn of civilization, he was worshipped as a god. Apocalypse, the first and most powerful mutant from Marvel’s X-Men universe, amassed the powers of many other mutants, becoming immortal and invincible. Upon awakening after thousands of years, he is disillusioned with the world as he finds it and recruits a team of powerful mutants, including a disheartened Magneto, to cleanse mankind and create a new world order, over which he will reign. As the fate of the Earth hangs in the balance, Raven with the help of Professor X must lead a team of young X-Men to stop their greatest nemesis and save mankind from complete destruction.\",\"release_date\":\"2016-05-18\",\"genre_ids\":[28,12,878,14],\"id\":246655,\"original_title\":\"X-Men: Apocalypse\",\"original_language\":\"en\",\"title\":\"X-Men: Apocalypse\",\"backdrop_path\":\"\\/oQWWth5AOtbWG9o8SCAviGcADed.jpg\",\"popularity\":32.838029,\"vote_count\":1240,\"video\":false,\"vote_average\":5.99},{\"poster_path\":\"\\/9KQX22BeFzuNM66pBA6JbiaJ7Mi.jpg\",\"adult\":false,\"overview\":\"We always knew they were coming back. Using recovered alien technology, the nations of Earth have collaborated on an immense defense program to protect the planet. But nothing can prepare us for the aliens’ advanced and unprecedented force. Only the ingenuity of a few brave men and women can bring our world back from the brink of extinction.\",\"release_date\":\"2016-06-22\",\"genre_ids\":[28,12,878],\"id\":47933,\"original_title\":\"Independence Day: Resurgence\",\"original_language\":\"en\",\"title\":\"Independence Day: Resurgence\",\"backdrop_path\":\"\\/8SqBiesvo1rh9P1hbJTmnVum6jv.jpg\",\"popularity\":28.073288,\"vote_count\":220,\"video\":false,\"vote_average\":4.64},{\"poster_path\":\"\\/z09QAf8WbZncbitewNk6lKYMZsh.jpg\",\"adult\":false,\"overview\":\"Dory is a wide-eyed, blue tang fish who suffers from memory loss every 10 seconds or so. The one thing she can remember is that she somehow became separated from her parents as a child. With help from her friends Nemo and Marlin, Dory embarks on an epic adventure to find them. Her journey brings her to the Marine Life Institute, a conservatory that houses diverse ocean species. Dory now knows that her family reunion will only happen if she can save mom and dad from captivity.\",\"release_date\":\"2016-06-16\",\"genre_ids\":[12,16,35],\"id\":127380,\"original_title\":\"Finding Dory\",\"original_language\":\"en\",\"title\":\"Finding Dory\",\"backdrop_path\":\"\\/iWRKYHTFlsrxQtfQqFOQyceL83P.jpg\",\"popularity\":26.071019,\"vote_count\":219,\"video\":false,\"vote_average\":6.23},{\"poster_path\":\"\\/cGOPbv9wA5gEejkUN892JrveARt.jpg\",\"adult\":false,\"overview\":\"Fearing the actions of a god-like Super Hero left unchecked, Gotham City’s own formidable, forceful vigilante takes on Metropolis’s most revered, modern-day savior, while the world wrestles with what sort of hero it really needs. And with Batman and Superman at war with one another, a new threat quickly arises, putting mankind in greater danger than it’s ever known before.\",\"release_date\":\"2016-03-23\",\"genre_ids\":[28,12,14],\"id\":209112,\"original_title\":\"Batman v Superman: Dawn of Justice\",\"original_language\":\"en\",\"title\":\"Batman v Superman: Dawn of Justice\",\"backdrop_path\":\"\\/vsjBeMPZtyB7yNsYY56XYxifaQZ.jpg\",\"popularity\":20.642218,\"vote_count\":2323,\"video\":false,\"vote_average\":5.63},{\"poster_path\":\"\\/inVq3FRqcYIRl2la8iZikYYxFNR.jpg\",\"adult\":false,\"overview\":\"Based upon Marvel Comics’ most unconventional anti-hero, DEADPOOL tells the origin story of former Special Forces operative turned mercenary Wade Wilson, who after being subjected to a rogue experiment that leaves him with accelerated healing powers, adopts the alter ego Deadpool. Armed with his new abilities and a dark, twisted sense of humor, Deadpool hunts down the man who nearly destroyed his life.\",\"release_date\":\"2016-02-09\",\"genre_ids\":[28,12,35,10749],\"id\":293660,\"original_title\":\"Deadpool\",\"original_language\":\"en\",\"title\":\"Deadpool\",\"backdrop_path\":\"\\/nbIrDhOtUpdD9HKDBRy02a8VhpV.jpg\",\"popularity\":17.845664,\"vote_count\":4023,\"video\":false,\"vote_average\":7.13},{\"poster_path\":\"\\/sM33SANp9z6rXW8Itn7NnG1GOEs.jpg\",\"adult\":false,\"overview\":\"Determined to prove herself, Officer Judy Hopps, the first bunny on Zootopia's police force, jumps at the chance to crack her first case - even if it means partnering with scam-artist fox Nick Wilde to solve the mystery.\",\"release_date\":\"2016-02-11\",\"genre_ids\":[16,12,10751,35],\"id\":269149,\"original_title\":\"Zootopia\",\"original_language\":\"en\",\"title\":\"Zootopia\",\"backdrop_path\":\"\\/mhdeE1yShHTaDbJVdWyTlzFvNkr.jpg\",\"popularity\":17.804106,\"vote_count\":1343,\"video\":false,\"vote_average\":7.37},{\"poster_path\":\"\\/5N20rQURev5CNDcMjHVUZhpoCNC.jpg\",\"adult\":false,\"overview\":\"Following the events of Age of Ultron, the collective governments of the world pass an act designed to regulate all superhuman activity. This polarizes opinion amongst the Avengers, causing two factions to side with Iron Man or Captain America, which causes an epic battle between former allies.\",\"release_date\":\"2016-04-27\",\"genre_ids\":[28,53,878],\"id\":271110,\"original_title\":\"Captain America: Civil War\",\"original_language\":\"en\",\"title\":\"Captain America: Civil War\",\"backdrop_path\":\"\\/m5O3SZvQ6EgD5XXXLPIP1wLppeW.jpg\",\"popularity\":17.680439,\"vote_count\":2060,\"video\":false,\"vote_average\":6.87},{\"poster_path\":\"\\/jjBgi2r5cRt36xF6iNUEhzscEcb.jpg\",\"adult\":false,\"overview\":\"Twenty-two years after the events of Jurassic Park, Isla Nublar now features a fully functioning dinosaur theme park, Jurassic World, as originally envisioned by John Hammond.\",\"release_date\":\"2015-06-09\",\"genre_ids\":[28,12,878,53],\"id\":135397,\"original_title\":\"Jurassic World\",\"original_language\":\"en\",\"title\":\"Jurassic World\",\"backdrop_path\":\"\\/dkMD5qlogeRMiEixC4YNPUvax2T.jpg\",\"popularity\":17.494831,\"vote_count\":4612,\"video\":false,\"vote_average\":6.62},{\"poster_path\":\"\\/is6QqgiPQlI3Wmk0bovqUFKM56B.jpg\",\"adult\":false,\"overview\":\"A young boxer is taken under the wing of a mob boss after his mother dies and his father is run out of town for being an abusive alcoholic.\",\"release_date\":\"2016-05-20\",\"genre_ids\":[18],\"id\":368596,\"original_title\":\"Back in the Day\",\"original_language\":\"en\",\"title\":\"Back in the Day\",\"backdrop_path\":\"\\/yySmUG29VgDdCROb9eer9L2kkKX.jpg\",\"popularity\":17.143766,\"vote_count\":25,\"video\":false,\"vote_average\":4.08},{\"poster_path\":\"\\/zNqbEgDguvR2j9qBxKjTKN3zClr.jpg\",\"adult\":false,\"overview\":\"The peaceful realm of Azeroth stands on the brink of war as its civilization faces a fearsome race of invaders: orc warriors fleeing their dying home to colonize another. As a portal opens to connect the two worlds, one army faces destruction and the other faces extinction. From opposing sides, two heroes are set on a collision course that will decide the fate of their family, their people, and their home.\",\"release_date\":\"2016-05-25\",\"genre_ids\":[28,12,14],\"id\":68735,\"original_title\":\"Warcraft\",\"original_language\":\"en\",\"title\":\"Warcraft\",\"backdrop_path\":\"\\/5SX2rgKXZ7NVmAJR5z5LprqSXKa.jpg\",\"popularity\":15.650077,\"vote_count\":435,\"video\":false,\"vote_average\":6.01},{\"poster_path\":\"\\/5JU9ytZJyR3zmClGmVm9q4Geqbd.jpg\",\"adult\":false,\"overview\":\"The year is 2029. John Connor, leader of the resistance continues the war against the machines. At the Los Angeles offensive, John's fears of the unknown future begin to emerge when TECOM spies reveal a new plot by SkyNet that will attack him from both fronts; past and future, and will ultimately change warfare forever.\",\"release_date\":\"2015-06-23\",\"genre_ids\":[878,28,53,12],\"id\":87101,\"original_title\":\"Terminator Genisys\",\"original_language\":\"en\",\"title\":\"Terminator Genisys\",\"backdrop_path\":\"\\/bIlYH4l2AyYvEysmS2AOfjO7Dn8.jpg\",\"popularity\":14.426813,\"vote_count\":2151,\"video\":false,\"vote_average\":5.97},{\"poster_path\":\"\\/nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg\",\"adult\":false,\"overview\":\"Interstellar chronicles the adventures of a group of explorers who make use of a newly discovered wormhole to surpass the limitations on human space travel and conquer the vast distances involved in an interstellar voyage.\",\"release_date\":\"2014-11-05\",\"genre_ids\":[12,18,878],\"id\":157336,\"original_title\":\"Interstellar\",\"original_language\":\"en\",\"title\":\"Interstellar\",\"backdrop_path\":\"\\/xu9zaAevzQ5nnrsXN6JcahLnG4i.jpg\",\"popularity\":14.253219,\"vote_count\":5181,\"video\":false,\"vote_average\":8.17},{\"poster_path\":\"\\/kqjL17yufvn9OVLyXYpvtyrFfak.jpg\",\"adult\":false,\"overview\":\"An apocalyptic story set in the furthest reaches of our planet, in a stark desert landscape where humanity is broken, and most everyone is crazed fighting for the necessities of life. Within this world exist two rebels on the run who just might be able to restore order. There's Max, a man of action and a man of few words, who seeks peace of mind following the loss of his wife and child in the aftermath of the chaos. And Furiosa, a woman of action and a woman who believes her path to survival may be achieved if she can make it across the desert back to her childhood homeland.\",\"release_date\":\"2015-05-13\",\"genre_ids\":[28,12,878,53],\"id\":76341,\"original_title\":\"Mad Max: Fury Road\",\"original_language\":\"en\",\"title\":\"Mad Max: Fury Road\",\"backdrop_path\":\"\\/tbhdm8UJAb4ViCTsulYFL3lxMCd.jpg\",\"popularity\":13.695335,\"vote_count\":4771,\"video\":false,\"vote_average\":7.31},{\"poster_path\":\"\\/h28t2JNNGrZx0fIuAw8aHQFhIxR.jpg\",\"adult\":false,\"overview\":\"A recently cheated on married woman falls for a younger man who has moved in next door, but their torrid affair soon takes a dangerous turn.\",\"release_date\":\"2015-01-23\",\"genre_ids\":[53],\"id\":241251,\"original_title\":\"The Boy Next Door\",\"original_language\":\"en\",\"title\":\"The Boy Next Door\",\"backdrop_path\":\"\\/vj4IhmH4HCMZYYjTMiYBybTWR5o.jpg\",\"popularity\":11.928843,\"vote_count\":401,\"video\":false,\"vote_average\":4.76},{\"poster_path\":\"\\/aBBQSC8ZECGn6Wh92gKDOakSC8p.jpg\",\"adult\":false,\"overview\":\"Beatrice Prior must confront her inner demons and continue her fight against a powerful alliance which threatens to tear her society apart.\",\"release_date\":\"2015-03-18\",\"genre_ids\":[12,878,53],\"id\":262500,\"original_title\":\"Insurgent\",\"original_language\":\"en\",\"title\":\"Insurgent\",\"backdrop_path\":\"\\/L5QRL1O3fGs2hH1LbtYyVl8Tce.jpg\",\"popularity\":11.744517,\"vote_count\":1969,\"video\":false,\"vote_average\":6.48},{\"poster_path\":\"\\/gj282Pniaa78ZJfbaixyLXnXEDI.jpg\",\"adult\":false,\"overview\":\"Katniss Everdeen reluctantly becomes the symbol of a mass rebellion against the autocratic Capitol.\",\"release_date\":\"2014-11-18\",\"genre_ids\":[878,12,53],\"id\":131631,\"original_title\":\"The Hunger Games: Mockingjay - Part 1\",\"original_language\":\"en\",\"title\":\"The Hunger Games: Mockingjay - Part 1\",\"backdrop_path\":\"\\/83nHcz2KcnEpPXY50Ky2VldewJJ.jpg\",\"popularity\":11.643196,\"vote_count\":2941,\"video\":false,\"vote_average\":6.75},{\"poster_path\":\"\\/tSFBh9Ayn5uiwbUK9HvD2lrRgaQ.jpg\",\"adult\":false,\"overview\":\"Beatrice Prior and Tobias Eaton venture into the world outside of the fence and are taken into protective custody by a mysterious agency known as the Bureau of Genetic Welfare.\",\"release_date\":\"2016-03-09\",\"genre_ids\":[12,878],\"id\":262504,\"original_title\":\"Allegiant\",\"original_language\":\"en\",\"title\":\"Allegiant\",\"backdrop_path\":\"\\/sFthBeT0Y3WVfg6b3MkcJs9qfzq.jpg\",\"popularity\":11.362547,\"vote_count\":441,\"video\":false,\"vote_average\":6.05},{\"poster_path\":\"\\/e3lBJCedHnZPfNfmBArKHZXXNC0.jpg\",\"adult\":false,\"overview\":\"Lorraine and Ed Warren travel to north London to help a single mother raising four children alone in a house plagued by malicious spirits.\",\"release_date\":\"2016-06-08\",\"genre_ids\":[27],\"id\":259693,\"original_title\":\"The Conjuring 2\",\"original_language\":\"en\",\"title\":\"The Conjuring 2\",\"backdrop_path\":\"\\/mj9jHyMvHfJ3oUZrisCoubItATk.jpg\",\"popularity\":10.897856,\"vote_count\":280,\"video\":false,\"vote_average\":6.13},{\"poster_path\":\"\\/q7GOSxRsBLTJysmAEjFoQZfScsq.jpg\",\"adult\":false,\"overview\":\"After he reunites with an old pal through Facebook, a mild-mannered accountant is lured into the world of international espionage.\",\"release_date\":\"2016-06-15\",\"genre_ids\":[28,35],\"id\":302699,\"original_title\":\"Central Intelligence\",\"original_language\":\"en\",\"title\":\"Central Intelligence\",\"backdrop_path\":\"\\/1XMYrOif2dmIeDrWysg4WmaTy3Q.jpg\",\"popularity\":10.509524,\"vote_count\":119,\"video\":false,\"vote_average\":4.9},{\"poster_path\":\"\\/weUSwMdQIa3NaXVzwUoIIcAi85d.jpg\",\"adult\":false,\"overview\":\"Thirty years after defeating the Galactic Empire, Han Solo and his allies face a new threat from the evil Kylo Ren and his army of Stormtroopers.\",\"release_date\":\"2015-12-15\",\"genre_ids\":[28,12,878,14],\"id\":140607,\"original_title\":\"Star Wars: The Force Awakens\",\"original_language\":\"en\",\"title\":\"Star Wars: The Force Awakens\",\"backdrop_path\":\"\\/c2Ax8Rox5g6CneChwy1gmu4UbSb.jpg\",\"popularity\":10.452581,\"vote_count\":4358,\"video\":false,\"vote_average\":7.56}],\"total_results\":19683,\"total_pages\":985}";

        RecyclerView recyclerView=(RecyclerView)findViewById(R.id.rv_movie);
        ArrayList<Movies.movie> movies=Movies.initialize_movie(jsonstr);
        MovieAdapter movieAdapter=new MovieAdapter(movies);

        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this, LinearLayout.HORIZONTAL,false);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(movieAdapter);
        movieAdapter.notifyDataSetChanged();
        recyclerView.setHasFixedSize(true);


       // Picasso.with(getApplicationContext()).load("http://image.tmdb.org/t/p/w780//nBNZadXqJSdt05SHLqgT0HuC5Gm.jpg").resize(300,300).into(ivTest);

    }

    public class MovieViewHolder extends RecyclerView.ViewHolder
    {
        ImageView ivMoviePoster;
        public MovieViewHolder(View itemView) {
            super(itemView);
            ivMoviePoster=(ImageView)itemView.findViewById(R.id.iv_movieposter);
        }


    }


    public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder>
    {
        ArrayList<Movies.movie> movieArrayList;

        public MovieAdapter(ArrayList<Movies.movie> movieArrayList) {
            this.movieArrayList = movieArrayList;
        }

        @Override
        public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater=getLayoutInflater();
            View itemview=inflater.inflate(R.layout.movie_list_item,parent,false);
            MovieViewHolder holder=new MovieViewHolder(itemview);

            return holder;
        }

        @Override
        public void onBindViewHolder(MovieViewHolder holder, int position) {

            Movies.movie mobject=movieArrayList.get(position);
            Picasso.with(getApplicationContext()).load(mobject.movie_url).into(holder.ivMoviePoster);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent go_deatil=new Intent(getApplicationContext(),Detail_Movie_Activity.class);
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
