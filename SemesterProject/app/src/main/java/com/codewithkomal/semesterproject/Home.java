package com.codewithkomal.semesterproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {

    Button Category1, Category2;
    //TextView textView;
    ImageView callprofile,callLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Category1 = findViewById(R.id.categ01);
        Category2 = findViewById(R.id.categ02);
        callprofile=(ImageView) findViewById(R.id.profile);
        callLogout=(ImageView) findViewById(R.id.logout);

        Category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Category2.class);
                startActivity(intent);
            }
        });

        Category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Category1.class);
                startActivity(intent);
            }
        });
        callprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Profile.class);
                startActivity(intent);
            }
        });

        callLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,Login.class);
                startActivity(intent);
                finish();
            }
        });
    }
}