package com.kazi_ruhol.bannerslider;

import android.content.Context;
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

public class ImageSliderAdapter4 extends SliderViewAdapter<SliderViewHolder> {

    Context context4;
    int setTotalCount4;
    String ImageLink4;

    public ImageSliderAdapter4(Context context4, int setTotalCount4) {
        this.context4 = context4;
        this.setTotalCount4 = setTotalCount4;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item4_layout,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        FirebaseDatabase.getInstance().getReference("cleaning").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                switch (position){
                    case 0:
                        ImageLink4 = dataSnapshot.child("1").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink4).into(viewHolder.sliderImageView4);
                        break;
                    case 1:
                        ImageLink4 = dataSnapshot.child("2").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink4).into(viewHolder.sliderImageView4);
                        break;
                    case 2:
                        ImageLink4 = dataSnapshot.child("3").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink4).into(viewHolder.sliderImageView4);
                        break;
                    case 3:
                        ImageLink4 = dataSnapshot.child("4").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink4).into(viewHolder.sliderImageView4);
                        break;
                    case 4:
                        ImageLink4 = dataSnapshot.child("5").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink4).into(viewHolder.sliderImageView4);
                        break;
                    case 5:
                        ImageLink4 = dataSnapshot.child("6").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink4).into(viewHolder.sliderImageView4);
                        break;
                    case 6:
                        ImageLink4 = dataSnapshot.child("7").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink4).into(viewHolder.sliderImageView4);
                        break;
                    case 7:
                        ImageLink4 = dataSnapshot.child("8").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink4).into(viewHolder.sliderImageView4);
                        break;
                    case 8:
                        ImageLink4 = dataSnapshot.child("9").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink4).into(viewHolder.sliderImageView4);
                        break;
                    case 9:
                        ImageLink4 = dataSnapshot.child("10").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink4).into(viewHolder.sliderImageView4);
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
        return setTotalCount4;
    }
}


