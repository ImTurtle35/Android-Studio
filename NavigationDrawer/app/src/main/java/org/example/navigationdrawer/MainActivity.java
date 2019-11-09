package org.example.navigationdrawer;

import android.content.Context;
import android.os.Bundle;

import androidx.core.view.GravityCompat;
import androidx.appcompat.app.ActionBarDrawerToggle;

import android.view.MenuItem;


import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.Menu;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActionBarDrawerToggle mdrawerToggle;
    Toolbar toolbar;
    RecyclerView.LayoutManager layoutManager;

    private DrawerLayout mDrawerLayout;
    private RecyclerView nav_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        nav_list = findViewById(R.id.list);
        layoutManager = new LinearLayoutManager(this);
        nav_list.setHasFixedSize(true);
        nav_list.setLayoutManager(layoutManager);
        mDrawerLayout = findViewById(R.id.drawer_layout);

        ArrayList<NavIcon>NavIconArrayList = new ArrayList<>();
        NavIconArrayList.add(new NavIcon(R.drawable.alarm,"알림"));
        NavIconArrayList.add(new NavIcon(R.drawable.box,"브랜치 공식 작가"));
        NavIconArrayList.add(new NavIcon(R.drawable.option,"브랜치 하트"));
        NavIconArrayList.add(new NavIcon(R.drawable.box,"재료 상자"));
        NavIconArrayList.add(new NavIcon(R.drawable.question,"재료 스폰서"));
        NavIconArrayList.add(new NavIcon(R.drawable.option,"설정"));
        NavIconArrayList.add(new NavIcon(R.drawable.question,"도움말"));
        NavIconArrayList.add(new NavIcon(R.drawable.hand_shake,"제휴제안"));

        NavIconAdapter navAdapter = new NavIconAdapter(NavIconArrayList);
        nav_list.setAdapter(navAdapter);
        mdrawerToggle = new ActionBarDrawerToggle(
                this,mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mdrawerToggle);
        mdrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
