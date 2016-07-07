package com.example.test.moviesapp;


import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawer;
    private Toolbar toolbar;
    private NavigationView nvDrawer;
    private ActionBarDrawerToggle drawerToggle;


    public static final String TAG = "haala";

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        selectDrawerItem(menuItem);
                        return true;
                    }
                });
    }

    public void selectDrawerItem(MenuItem menuItem) {
        Intent i = new Intent(MainActivity.this, OtherCategoryActivity.class);


        switch (menuItem.getItemId()) {

            case R.id.nav_tv:

                i.putExtra("pos", 1);
                startActivity(i);
                break;
            case R.id.nav_celebs:

                i.putExtra("pos", 2);
                startActivity(i);
                break;
            case R.id.nav_review:

                i.putExtra("pos", 3);
                startActivity(i);
                break;

        }

        menuItem.setChecked(true);
        mDrawer.closeDrawers();


    }


    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    void settoolbar_nav() {

        toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);


        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        nvDrawer = (NavigationView) findViewById(R.id.nvView);
        setupDrawerContent(nvDrawer);
        drawerToggle= new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.drawer_open,  R.string.drawer_close);
        mDrawer.addDrawerListener(drawerToggle);
        Menu menu=nvDrawer.getMenu();
        menu.findItem(R.id.menu_search).setVisible(false);


    }





        // ActionBarDrawerToggle mtoggle = new ActionBarDrawerToggle(this, mdrawer, myToolbar, R.string.app_name, R.string.app_name);

      /*  final ListView mdrawerlist = (ListView) findViewById(R.id.left_drawer);
        if (mdrawerlist != null) {
            mdrawerlist.setAdapter(new ArrayAdapter<String>(this,
                    R.layout.drawer_list_item, Titles));
        }
        if (mdrawerlist != null) {
            mdrawerlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position == 0) {
                        mdrawerlist.setItemChecked(position, true);
                        mdrawer.closeDrawer(mdrawerlist);


                    } else {
                        Intent i = new Intent(MainActivity.this, OtherCategoryActivity.class);
                        i.putExtra("pos", position);
                        startActivity(i);


                    }
                }
            });
        }

*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (!isNetworkAvailable()) {
            Toast.makeText(MainActivity.this, "Please Connect To Internet", Toast.LENGTH_SHORT).show();
            finish();
        }
        settoolbar_nav();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isNetworkAvailable()) {

            System.exit(0);
        }
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String frag1 = prefs.getString(getString(R.string.mv_cat_key),
                "0");
        String frag2 = prefs.getString(getString(R.string.mv_cat_key1),
                "1");

        DisplaySection top = null;
        DisplaySection bottom = null;
        switch (frag1) {
            case "0":
                top = DisplaySection.newInstance("Most Popular Movies", "http://api.themoviedb.org/3/movie/popular?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "1":
                top = DisplaySection.newInstance("Top Rated Movies", "http://api.themoviedb.org/3/movie/top_rated?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "2":
                top = DisplaySection.newInstance("Upcoming Movies", "http://api.themoviedb.org/3/movie/upcoming?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "3":
                top = DisplaySection.newInstance("Currently Playing", "http://api.themoviedb.org/3/movie/now_playing?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;

        }
        switch (frag2) {

            case "0":
                bottom = DisplaySection.newInstance("Most Popular Movies", "http://api.themoviedb.org/3/movie/popular?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "1":
                bottom = DisplaySection.newInstance("Top Rated Movies", "http://api.themoviedb.org/3/movie/top_rated?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "2":
                bottom = DisplaySection.newInstance("Upcoming Movies", "http://api.themoviedb.org/3/movie/upcoming?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;
            case "3":
                bottom = DisplaySection.newInstance("Currently Playing", "http://api.themoviedb.org/3/movie/now_playing?api_key=a444d7a7a662a5a702515b3735ee4f49");
                break;

        }
        FragmentManager mngr = getSupportFragmentManager();

        FragmentTransaction txn = mngr.beginTransaction();
        txn.add(R.id.frag_container_1, top, null);
        txn.add(R.id.frag_container_2, bottom, null).commit();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.drawer_view, menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings)
            startActivity(new Intent(this, SettingActivity.class));
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }




        return true;

    }


    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }


}
