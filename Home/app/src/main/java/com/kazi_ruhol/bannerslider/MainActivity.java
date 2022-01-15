package com.kazi_ruhol.bannerslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kazi_ruhol.bannerslider.databinding.ActivityMainBinding;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends DrawerBaseActivity {
    ActivityMainBinding activityMainBinding;

    SliderView sliderView,sliderView2,sliderView3,sliderView4,sliderView5;
    int TotalCounts,TotalCounts2,TotalCounts3,TotalCounts4,TotalCounts5;
    Button darazbtn, pathaobtn, uberbtn, shopnobtn, tanbinabtn;
    ToggleButton favbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());

        sliderView = findViewById(R.id.imageSlider);
        sliderView2 = findViewById(R.id.imageSlider2);
        sliderView3 = findViewById(R.id.imageSlider3);
        sliderView4 = findViewById(R.id.imageSlider4);
        sliderView5 = findViewById(R.id.imageSlider5);
        darazbtn = findViewById(R.id.daraz_button);
        pathaobtn = findViewById(R.id.pathao_button);
        uberbtn = findViewById(R.id.uber_button);
        shopnobtn = findViewById(R.id.shopno_button);
        tanbinabtn = findViewById(R.id.tanniba_button);
        favbtn = findViewById(R.id.daraz_fav_button);



        pathaobtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoUrl("https://www.google.com/");
            }
        });
        favbtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(favbtn.isChecked()==true){
                    Toast.makeText(MainActivity.this, "Added to Favourites", Toast.LENGTH_SHORT).show();
                }
                if (favbtn.isChecked()==false){
                    Toast.makeText(MainActivity.this, "Removed From Favourites", Toast.LENGTH_SHORT).show();
                }
            }
        });
        darazbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Added to Favourites", Toast.LENGTH_SHORT).show();

//                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
//                startActivity(intent);
            }
        });



        FirebaseDatabase.getInstance().getReference("ImagesLinks").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long counts = dataSnapshot.getChildrenCount();
                TotalCounts = counts.intValue();
                sliderView.setSliderAdapter(new ImageSliderAdapter(MainActivity.this,TotalCounts));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("kitchen").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long counts2 = dataSnapshot.getChildrenCount();
                TotalCounts2 = counts2.intValue();
                sliderView2.setSliderAdapter(new ImageSliderAdapter2(MainActivity.this,TotalCounts2));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("gadgets").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long counts3 = dataSnapshot.getChildrenCount();
                TotalCounts3 = counts3.intValue();
                sliderView3.setSliderAdapter(new ImageSliderAdapter3(MainActivity.this,TotalCounts3));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("cleaning").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long counts4 = dataSnapshot.getChildrenCount();
                TotalCounts4 = counts4.intValue();
                sliderView4.setSliderAdapter(new ImageSliderAdapter4(MainActivity.this,TotalCounts4));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        FirebaseDatabase.getInstance().getReference("cosmetics").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Long counts5 = dataSnapshot.getChildrenCount();
                TotalCounts5 = counts5.intValue();
                sliderView5.setSliderAdapter(new ImageSliderAdapter5(MainActivity.this,TotalCounts5));

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });








    }

    private void gotoUrl(String s) {
        Uri uri = Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void openChrome(View view){

        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.ubercab");
        if(launchIntent != null){
            startActivity(launchIntent);
        }
        else{
            Toast.makeText(MainActivity.this, "Download Your App First", Toast.LENGTH_SHORT).show();
        }
    }


}