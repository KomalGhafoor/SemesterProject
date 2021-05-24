package com.codewithkomal.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Category1 extends AppCompatActivity {

    Button BackToHome, GirlsHostelList, BoysHostelList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category1);

        BackToHome = findViewById(R.id.backToHome);
        GirlsHostelList = findViewById(R.id.girllist1);
        BoysHostelList = findViewById(R.id.boylist1);

        BackToHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category1.this,Home.class);
                startActivity(intent);
            }
        });

        GirlsHostelList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category1.this,girlList1.class);
                startActivity(intent);
            }
        });

        BoysHostelList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Category1.this,boyList1.class);
                startActivity(intent);
            }
        });
    }
}