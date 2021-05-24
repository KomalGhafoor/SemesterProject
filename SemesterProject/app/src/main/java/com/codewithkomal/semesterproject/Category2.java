package com.codewithkomal.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Category2 extends AppCompatActivity {

    Button BackToHome, GirlsHostelList, BoysHostelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category2);

        BackToHome = findViewById(R.id.backToHome);
        GirlsHostelList = findViewById(R.id.firstList);
        BoysHostelList = findViewById(R.id.secondList);

        BackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category2.this,Home.class);
                startActivity(intent);
            }
        });

        GirlsHostelList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category2.this,girlList2.class);
                startActivity(intent);
            }
        });

        BoysHostelList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category2.this,boyList2.class);
                startActivity(intent);
            }
        });
    }
}