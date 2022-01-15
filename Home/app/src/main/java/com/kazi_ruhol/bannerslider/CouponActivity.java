package com.kazi_ruhol.bannerslider;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kazi_ruhol.bannerslider.databinding.ActivityCouponBinding;

public class CouponActivity extends DrawerBaseActivity {
    ActivityCouponBinding activityCouponBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCouponBinding = ActivityCouponBinding.inflate(getLayoutInflater());
        setContentView(activityCouponBinding.getRoot());
        allocatedActivityTitle("Coupon");
    }
}