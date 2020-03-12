package com.example.bigscouting2020;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.bigscouting2020.ui.main.Tab1;
import com.example.bigscouting2020.ui.main.Tab2;
import com.example.bigscouting2020.ui.main.Tab3;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import com.example.bigscouting2020.ui.main.SectionsPagerAdapter;

public class ScouterActivity extends AppCompatActivity implements Tab1.OnFragmentInteractionListener, Tab2.OnFragmentInteractionListener, Tab3.OnFragmentInteractionListener{

    public int teamNumber;
    public int matchNumber;
    public String level;
    public String alliance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scouter);

        Intent intent = getIntent();
        teamNumber = intent.getIntExtra(Constants.TeamNumber, -1);
        matchNumber = intent.getIntExtra(Constants.MatchNumber, -1);
        level = intent.getStringExtra(Constants.Level);
        alliance = intent.getStringExtra(Constants.Alliance);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Autonomous"));
        tabLayout.addTab(tabLayout.newTab().setText("Tele-Op"));
        tabLayout.addTab(tabLayout.newTab().setText("Endgame"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final SectionsPagerAdapter adapter = new SectionsPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onFragmentInteraction(Uri uri)
    {

    }

    public void onSubmit(View v)
    {
        syncWithDatabase();

        Intent intent = new Intent(this, LoadingScreenActivity.class);
        intent.putExtra(Constants.Level, level);
        intent.putExtra(Constants.Alliance, alliance);
        intent.putExtra(Constants.MatchNumber, matchNumber + 1);
        
        startActivity(intent);

    }

    public void syncWithDatabase()
    {
        // do stuff here, good luck bro
    }



}