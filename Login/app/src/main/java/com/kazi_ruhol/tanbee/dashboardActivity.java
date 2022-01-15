package com.kazi_ruhol.tanbee;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class dashboardActivity extends AppCompatActivity
   // private FrameLayout frameLayout;

{



    ////////////
    private ViewPager bannerSliderViewPager;
    private List<SliderModel>sliderModelList;
    private int currentPage = 1;
    private Timer timer;
    final private long DELAY_TIME = 3000;
    final private long PERIOD_TIME = 3000;
    ///////////

    //@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_dashboard,container,false);

        bannerSliderViewPager = view.findViewById(R.id.banner_slider_view_pager);
        sliderModelList = new ArrayList<SliderModel>();


        sliderModelList.add(new SliderModel(R.drawable.index4));

        sliderModelList.add(new SliderModel(R.drawable.index2));
        sliderModelList.add(new SliderModel(R.drawable.index3));
        sliderModelList.add(new SliderModel(R.drawable.index4));

        sliderModelList.add(new SliderModel(R.drawable.index2));



        SliderAdapter sliderAdapter = new SliderAdapter(sliderModelList);
        bannerSliderViewPager.setAdapter(sliderAdapter);
        bannerSliderViewPager.setClipToPadding(false);
        bannerSliderViewPager.setPageMargin(20);

        ViewPager.OnPageChangeListener onPageChangeListener = new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                currentPage = i;
            }

            @Override
            public void onPageScrollStateChanged(int i) {
                if(i == ViewPager.SCROLL_STATE_IDLE){
                    pageLooper();
                }
            }
        };

        bannerSliderViewPager.addOnPageChangeListener(onPageChangeListener);



        startBannerSlideShow();

        bannerSliderViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                pageLooper();
                stopBannerSlideShow();
                if(event.getAction() == MotionEvent.ACTION_UP){
                    startBannerSlideShow();
                }


                return false;
            }
        });


        return view;
    }



    private void startBannerSlideShow(){
        Handler handler = new Handler();
        Runnable update = new Runnable() {
            @Override
            public void run() {
                if(currentPage >= sliderModelList.size()){
                    currentPage = 1;
                }
                bannerSliderViewPager.setCurrentItem(currentPage++,true);
            }
        };
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        },DELAY_TIME,PERIOD_TIME);

    }
    private void stopBannerSlideShow(){
        timer.cancel();


    }
    private void pageLooper(){
        if(currentPage == sliderModelList.size() - 1){
            currentPage = 1;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }
        if(currentPage == 1){
            currentPage = sliderModelList.size() - 2;
            bannerSliderViewPager.setCurrentItem(currentPage,false);
        }


    }





}