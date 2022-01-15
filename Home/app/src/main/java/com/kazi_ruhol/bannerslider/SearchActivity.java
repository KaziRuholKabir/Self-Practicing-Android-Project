package com.kazi_ruhol.bannerslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kazi_ruhol.bannerslider.databinding.ActivityProfileBinding;

public class SearchActivity extends DrawerBaseActivity {
    ActivityProfileBinding activityProfileBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityProfileBinding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(activityProfileBinding.getRoot());
        allocatedActivityTitle("Search");
    }
}