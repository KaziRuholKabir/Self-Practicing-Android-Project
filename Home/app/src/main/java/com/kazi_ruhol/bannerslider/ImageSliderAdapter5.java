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

public class ImageSliderAdapter5 extends SliderViewAdapter<SliderViewHolder> {

    Context context5;
    int setTotalCount5;
    String ImageLink5;

    public ImageSliderAdapter5(Context context5, int setTotalCount5) {
        this.context5 = context5;
        this.setTotalCount5 = setTotalCount5;
    }

    @Override
    public SliderViewHolder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item5_layout,parent,false);
        return new SliderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SliderViewHolder viewHolder, int position) {
        FirebaseDatabase.getInstance().getReference("cosmetics").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                switch (position){
                    case 0:
                        ImageLink5 = dataSnapshot.child("1").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink5).into(viewHolder.sliderImageView5);
                        break;
                    case 1:
                        ImageLink5 = dataSnapshot.child("2").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink5).into(viewHolder.sliderImageView5);
                        break;
                    case 2:
                        ImageLink5 = dataSnapshot.child("3").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink5).into(viewHolder.sliderImageView5);
                        break;
                    case 3:
                        ImageLink5 = dataSnapshot.child("4").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink5).into(viewHolder.sliderImageView5);
                        break;
                    case 4:
                        ImageLink5 = dataSnapshot.child("5").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink5).into(viewHolder.sliderImageView5);
                        break;
                    case 5:
                        ImageLink5 = dataSnapshot.child("6").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink5).into(viewHolder.sliderImageView5);
                        break;
                    case 6:
                        ImageLink5 = dataSnapshot.child("7").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink5).into(viewHolder.sliderImageView5);
                        break;
                    case 7:
                        ImageLink5 = dataSnapshot.child("8").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink5).into(viewHolder.sliderImageView5);
                        break;
                    case 8:
                        ImageLink5 = dataSnapshot.child("9").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink5).into(viewHolder.sliderImageView5);
                        break;
                    case 9:
                        ImageLink5 = dataSnapshot.child("10").getValue().toString();
                        Glide.with(viewHolder.itemView).load(ImageLink5).into(viewHolder.sliderImageView5);
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
        return setTotalCount5;
    }
}


