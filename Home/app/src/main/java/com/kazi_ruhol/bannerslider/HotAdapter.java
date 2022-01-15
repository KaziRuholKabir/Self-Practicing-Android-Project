package com.kazi_ruhol.bannerslider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

import org.w3c.dom.Text;

public class HotAdapter extends FirebaseRecyclerAdapter<model, HotAdapter.hotviewholder> {


    public HotAdapter(@NonNull FirebaseRecyclerOptions<model> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull hotviewholder holder, int position, @NonNull model model) {


        holder.name.setText(model.getName());


        Glide.with(holder.img.getContext()).load(model.getImage()).into(holder.img);

    }

    @NonNull
    @Override
    public hotviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hot_row,parent,false);
        return new hotviewholder(view);
    }

    class hotviewholder extends RecyclerView.ViewHolder{


        ImageView img;
        TextView name;
        public hotviewholder(@NonNull View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img1);
            name=(TextView) itemView.findViewById(R.id.nametext);
        }
    }

}
