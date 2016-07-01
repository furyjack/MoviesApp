package com.example.test.moviesapp;

import android.content.Intent;
import android.os.Bundle;
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
         DisplaySectionTv top=DisplaySectionTv.newInstance("Most Popular TV","http://api.themoviedb.org/3/tv/popular?api_key=a444d7a7a662a5a702515b3735ee4f49");
            DisplaySectionTv bottom=DisplaySectionTv.newInstance("Now On Air","http://api.themoviedb.org/3/tv/on_the_air?api_key=a444d7a7a662a5a702515b3735ee4f49");

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

        return true;

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        startActivity(new Intent(this,SettingActivity.class));


        return true;

    }




}
