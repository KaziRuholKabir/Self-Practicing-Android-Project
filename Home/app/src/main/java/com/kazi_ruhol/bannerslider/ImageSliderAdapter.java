package com.kazi_ruhol.bannerslider;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.List;

public class ImageSliderAdapter extends SliderViewAdapter<SliderViewHolder> {

    Context context;
    int setTotalCount;
    String ImageLink;


    public ImageSliderAdapter(Context context,int setTotalCount) {
        this.setTotalCount = setTotalCount;
        this.context = context;

    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item_layout,parent,false);
        return new SliderViewHolder(view);
    }



    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        FirebaseDatabase.getInstance().getReference("ImagesLinks").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                switch (position){
                    case 0:
                        ImageLink = dataSnapshot.child("1").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink).into(viewHolder.sliderImageView);
                        break;
                    case 1:
                        ImageLink = dataSnapshot.child("2").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink).into(viewHolder.sliderImageView);
                        break;
                    case 2:
                        ImageLink = dataSnapshot.child("3").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink).into(viewHolder.sliderImageView);
                        break;
                    case 3:
                        ImageLink = dataSnapshot.child("4").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink).into(viewHolder.sliderImageView);
                        break;
                    case 4:
                        ImageLink = dataSnapshot.child("5").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink).into(viewHolder.sliderImageView);
                        break;
                    case 5:
                        ImageLink = dataSnapshot.child("6").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink).into(viewHolder.sliderImageView);
                        break;
                    case 6:
                        ImageLink = dataSnapshot.child("7").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink).into(viewHolder.sliderImageView);
                        break;
                    case 7:
                        ImageLink = dataSnapshot.child("8").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink).into(viewHolder.sliderImageView);
                        break;
                    case 8:
                        ImageLink = dataSnapshot.child("9").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink).into(viewHolder.sliderImageView);
                        break;
                    case 9:
                        ImageLink = dataSnapshot.child("10").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink).into(viewHolder.sliderImageView);
                        break;


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

    @Override
    public int getCount() {

        return setTotalCount;

    }
}


