package com.kazi_ruhol.bannerslider;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.smarteist.autoimageslider.SliderViewAdapter;

class SliderViewHolder extends SliderViewAdapter.ViewHolder {
    ImageView sliderImageView, sliderImageView2, sliderImageView3, sliderImageView4, sliderImageView5;
    View itemView;

    public SliderViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        sliderImageView = itemView.findViewById(R.id.imageView);
        sliderImageView2 = itemView.findViewById(R.id.imageView2);
        sliderImageView3 = itemView.findViewById(R.id.imageView3);
        sliderImageView4 = itemView.findViewById(R.id.imageView4);
        sliderImageView5 = itemView.findViewById(R.id.imageView5);

    }
}
