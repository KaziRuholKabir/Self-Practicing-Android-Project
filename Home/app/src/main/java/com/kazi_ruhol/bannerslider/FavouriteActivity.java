package com.kazi_ruhol.bannerslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kazi_ruhol.bannerslider.databinding.ActivityFavouriteBinding;

public class FavouriteActivity extends DrawerBaseActivity {
    ActivityFavouriteBinding activityFavouriteBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityFavouriteBinding = ActivityFavouriteBinding.inflate(getLayoutInflater());
        setContentView(activityFavouriteBinding.getRoot());
        allocatedActivityTitle("Favourites");
    }
}