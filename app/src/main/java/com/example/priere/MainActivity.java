package com.example.priere;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.priere.R;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton b1 = findViewById(R.id.b1);
        ImageButton b2 = findViewById(R.id.b2);
        ImageButton b3 = findViewById(R.id.b3);
        ImageButton b4 = findViewById(R.id.b4);
        ImageButton b5 = findViewById(R.id.b5);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);


    }


    private void removeLayout(int i ){
        for (int j=1 ; j<6 ; j++){
            if (j!= i){
                LinearLayout layoutToRemove = findViewById(getResources().getIdentifier("ly" + j, "id", getPackageName()));
                layoutToRemove.removeAllViews();
            }
        };
    }
    private void addImagesToLayout(int j ,int[] imageResources) {
        LinearLayout ly = findViewById(getResources().getIdentifier("ly" + j, "id", getPackageName()));

        for (int i = 0; i < imageResources.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imageResources[i]);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(300, 300));

            ly.addView(imageView);
        }
    }

    @Override
    public void onClick(View v) {
        int[] imageetapes = {R.drawable.etap1, R.drawable.etap2, R.drawable.etap3, R.drawable.etap4, R.drawable.etap5,  R.drawable.etap6};


        int id = v.getId();
        if (id== R.id.b1){
            removeLayout(1);
            Toast.makeText(MainActivity.this, "has 2 raca'at", Toast.LENGTH_SHORT).show();

            addImagesToLayout(1,imageetapes);

        }else if (id == R.id.b2){
            Toast.makeText(MainActivity.this, "has 4 raca'at", Toast.LENGTH_SHORT).show();

            removeLayout(2);
            addImagesToLayout(2, imageetapes);

        } else if (id == R.id.b3) {
            Toast.makeText(MainActivity.this, "has 4 raca'at", Toast.LENGTH_SHORT).show();
            removeLayout(3);
            addImagesToLayout(3, imageetapes);

        } else if (id==R.id.b4) {
            Toast.makeText(MainActivity.this, "has 3 raca'at", Toast.LENGTH_SHORT).show();
            removeLayout(4);
            addImagesToLayout(4, imageetapes);
        }else {
            Toast.makeText(MainActivity.this, "has 4 + 2 + 1  raca'at", Toast.LENGTH_SHORT).show();
            removeLayout(5);
            addImagesToLayout(5,imageetapes);


        }
    }
}