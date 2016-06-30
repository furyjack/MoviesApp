package com.example.test.moviesapp;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
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

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_menu_white_48dp, R.string.app_name, R.string.app_name);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, mPlanetTitles));

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager mngr=getSupportFragmentManager();
        DisplaySection popular=DisplaySection.newInstance("Most Popular Movies","http://api.themoviedb.org/3/movie/popular?api_key=a444d7a7a662a5a702515b3735ee4f49");
        DisplaySection toprated=DisplaySection.newInstance("Top Rated Movies","http://api.themoviedb.org/3/movie/top_rated?api_key=a444d7a7a662a5a702515b3735ee4f49");
        FragmentTransaction txn=mngr.beginTransaction();
        txn.add(R.id.frag_container_1,popular,null);
        txn.add(R.id.frag_container_2,toprated,null).commit();




    }



}
