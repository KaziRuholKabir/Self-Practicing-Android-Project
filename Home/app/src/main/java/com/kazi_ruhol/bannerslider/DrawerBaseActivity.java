package com.kazi_ruhol.bannerslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.google.android.material.navigation.NavigationView;

public class DrawerBaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;

    @Override
    public void setContentView(View view) {
        drawerLayout = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_drawer_base, null);
        FrameLayout container = drawerLayout.findViewById(R.id.activityContainer);

        container.addView(view);

        super.setContentView(drawerLayout);

        Toolbar toolbar = drawerLayout.findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);


        NavigationView navigationView = drawerLayout.findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.menu_drawer_open,R.string.menu_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);

        switch(item.getItemId()){
            case R.id.nav_search:
                startActivity(new Intent(this,SearchActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_hot:
                startActivity(new Intent(this,HotActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_home:
                startActivity(new Intent(this,MainActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_feed:
                startActivity(new Intent(this,FeedActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_profile:
                startActivity(new Intent(this,ProfileActivity.class));
                overridePendingTransition(0,0);
                break;

            case R.id.nav_coupon:
                startActivity(new Intent(this,CouponActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_discounts:
                startActivity(new Intent(this,DiscountActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_favourites:
                startActivity(new Intent(this,FavouriteActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_report:
                startActivity(new Intent(this,ReportActivity.class));
                overridePendingTransition(0,0);
                break;
            case R.id.nav_signOut:
                startActivity(new Intent(this,MainActivity.class));
                overridePendingTransition(0,0);
                break;
        }

        return false;
    }

    protected void allocatedActivityTitle(String titleString){
        if(getSupportActionBar() !=null){
            getSupportActionBar().setTitle(titleString);
        }


    }



}