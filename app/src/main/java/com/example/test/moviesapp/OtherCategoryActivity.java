package com.example.test.moviesapp;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

public class OtherCategoryActivity extends AppCompatActivity {
    public static final String TAG = "haala";
 private int pos;


    void settoolbar_nav()
    {

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        myToolbar.setTitle(R.string.app_name);
        String[] Titles=getResources().getStringArray(R.array.titile);
        final DrawerLayout mdrawer=(DrawerLayout)findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mtoggle=new ActionBarDrawerToggle(this,mdrawer,myToolbar,R.string.app_name,R.string.app_name);
        mtoggle.setHomeAsUpIndicator(R.drawable.ic_drawer);
        myToolbar.setNavigationIcon(R.drawable.ic_drawer);
        final ListView mdrawerlist=(ListView)findViewById(R.id.left_drawer);
        if (mdrawerlist != null) {
            mdrawerlist.setAdapter(new ArrayAdapter<String>(this,
                    R.layout.drawer_list_item, Titles));
        }
        if (mdrawerlist != null) {
            mdrawerlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if(position==0)
                    {


                        Intent i=new Intent(OtherCategoryActivity.this,MainActivity.class);
                        startActivity(i);



                    }
                    else if(position==pos)
                    {

                        mdrawerlist.setItemChecked(position, true);
                        mdrawer.closeDrawer(mdrawerlist);


                    }
                    else
                    {

                        Intent i=new Intent(OtherCategoryActivity.this,OtherCategoryActivity.class);
                        i.putExtra("pos",position);
                        startActivity(i);

                    }
                }
            });
        }


    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         pos = getIntent().getIntExtra("pos", 0);
        settoolbar_nav();

    }

    @Override
    protected void onResume() {
        super.onResume();
        FragmentManager mngr=getSupportFragmentManager();

        FragmentTransaction txn=mngr.beginTransaction();

        if(pos==1)
        {
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
            String frag1 = prefs.getString(getString(R.string.tv_cat_key1),
                    "0");
            String frag2 = prefs.getString(getString(R.string.tv_cat_key2),
                    "1");
            DisplaySectionTv top=null;
            DisplaySectionTv bottom=null;



            switch (frag1)
            {
                case "0":
                    top=DisplaySectionTv.newInstance("Most Popular Shows","http://api.themoviedb.org/3/tv/popular?api_key=a444d7a7a662a5a702515b3735ee4f49");
                    break;
                case "1":
                    top=DisplaySectionTv.newInstance("Top Rated Shows","http://api.themoviedb.org/3/tv/top_rated?api_key=a444d7a7a662a5a702515b3735ee4f49");
                    break;
                case "2":
                    top=DisplaySectionTv.newInstance("On the Air","http://api.themoviedb.org/3/tv/on_the_air?api_key=a444d7a7a662a5a702515b3735ee4f49");
                    break;
                case "3":
                    top=DisplaySectionTv.newInstance("Airing Today","http://api.themoviedb.org/3/tv/airing_today?api_key=a444d7a7a662a5a702515b3735ee4f49");
                    break;

            }
            switch (frag2)
            {
                case "0":
                    bottom=DisplaySectionTv.newInstance("Most Popular Shows","http://api.themoviedb.org/3/tv/popular?api_key=a444d7a7a662a5a702515b3735ee4f49");
                    break;
                case "1":
                    bottom=DisplaySectionTv.newInstance("Top Rated Shows","http://api.themoviedb.org/3/tv/top_rated?api_key=a444d7a7a662a5a702515b3735ee4f49");
                    break;
                case "2":
                    bottom=DisplaySectionTv.newInstance("On the Air","http://api.themoviedb.org/3/tv/on_the_air?api_key=a444d7a7a662a5a702515b3735ee4f49");
                    break;
                case "3":
                    bottom=DisplaySectionTv.newInstance("Airing Today","http://api.themoviedb.org/3/tv/airing_today?api_key=a444d7a7a662a5a702515b3735ee4f49");
                    break;

            }





            txn.add(R.id.frag_container_1,top,null);
            txn.add(R.id.frag_container_2,bottom,null).commit();



        }
        else

        {

          comingsoonfrag comingsoonfrag=new comingsoonfrag();

            txn.add(R.id.frag_container_1,comingsoonfrag,null).commit();





        }




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconifiedByDefault(false);

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()== R.id.action_settings)
        startActivity(new Intent(this,SettingActivity.class));


        return true;

    }




}
