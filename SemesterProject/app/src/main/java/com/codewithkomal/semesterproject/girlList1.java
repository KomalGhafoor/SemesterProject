package com.codewithkomal.semesterproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class girlList1 extends AppCompatActivity {

    Button movetoCat1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_girl_list1);

        movetoCat1 = findViewById(R.id.c1);

        movetoCat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(girlList1.this,Category1.class);
                startActivity(intent);
            }
        });
    }
}