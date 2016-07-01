package com.example.test.moviesapp;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends AppCompatActivity {


    public static final String TAG = "haala";

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;


    void set_naviagtion() {
        String[] mPlanetTitles = {"item1", "item2", "item3", "item4"};
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);



        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mPlanetTitles));

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle(R.string.app_name);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,true,
                R.drawable.ic_menu_white_48dp, R.string.app_name, R.string.app_name);

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String frag1 = prefs.getString(getString(R.string.mv_cat_key),
                "Most Popular");
        String frag2 = prefs.getString(getString(R.string.mv_cat_key1),
                "Top Rated");

        DisplaySection top=null;
        DisplaySection bottom=null;
        switch (frag1)
        {
            case "0":
                top=DisplaySection.newInstance("Most Popular Movies","http://api.themoviedb.org/3/movie/popular?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "1":
                top=DisplaySection.newInstance("Top Rated Movies","http://api.themoviedb.org/3/movie/top_rated?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "2":
                top=DisplaySection.newInstance("Upcoming Movies","http://api.themoviedb.org/3/movie/upcoming?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "3":
                top=DisplaySection.newInstance("Currently Playing","http://api.themoviedb.org/3/movie/now_playing?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;

        }
        switch (frag2)
        {

            case "0":
                bottom=DisplaySection.newInstance("Most Popular Movies","http://api.themoviedb.org/3/movie/popular?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "1":
                bottom=DisplaySection.newInstance("Top Rated Movies","http://api.themoviedb.org/3/movie/top_rated?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "2":
                bottom=DisplaySection.newInstance("Upcoming Movies","http://api.themoviedb.org/3/movie/upcoming?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "3":
                bottom=DisplaySection.newInstance("Currently Playing","http://api.themoviedb.org/3/movie/now_playing?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;

        }
        FragmentManager mngr=getSupportFragmentManager();

        FragmentTransaction txn=mngr.beginTransaction();
        txn.add(R.id.frag_container_1,top,null);
        txn.add(R.id.frag_container_2,bottom,null).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this,SettingActivity.class));


        return true;

    }
}
