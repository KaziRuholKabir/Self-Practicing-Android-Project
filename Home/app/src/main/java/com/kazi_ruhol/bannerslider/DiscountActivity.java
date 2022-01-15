package com.kazi_ruhol.bannerslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kazi_ruhol.bannerslider.databinding.ActivityDiscountBinding;

public class DiscountActivity extends DrawerBaseActivity {
    ActivityDiscountBinding activityDiscountBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDiscountBinding = ActivityDiscountBinding.inflate(getLayoutInflater());
        setContentView(activityDiscountBinding.getRoot());
        allocatedActivityTitle("Discounts");
    }
}